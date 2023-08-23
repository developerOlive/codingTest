package 구현;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/92341
 */
public class 주차요금계산_카카오블라인드_2022 {


    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "18:59 0000 IN",

                "07:59 0148 IN",
                "19:09 0148 OUT",
                "05:34 5961 IN",
                "07:59 5961 OUT",

                "22:59 5961 IN",
                "23:00 5961 OUT"
        };

        System.out.println(Arrays.toString(solution(fees, records)));
    }


    // 시간을 분 단위로 계산하는 메서드
    public static int changeHourToMin(String time) {
        String[] tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }

    public static int[] solution(int[] fees, String[] records) {
        // 차량의 입차 시간 저장 (차량번호, 입차시간)
        Map<String, Integer> inTimeMap = new HashMap<>();

        // 차량별 누적 주차 시간 저장 (차량번호, 누적주차시간) / 차량번호 오름차순대로 결과를 반환하기 위해 treeMap 사용
        Map<String, Integer> totalParkingTimeMap = new TreeMap<>();

        // 주차 기록을 순회하며 계산
        for (String record : records) {
            String[] parts = record.split(" ");
            int nowTime = changeHourToMin(parts[0]);
            String carNum = parts[1];

            if (parts[2].equals("IN")) {
                inTimeMap.put(carNum, nowTime); // 입차 기록 저장
            } else {
                // 출차까지의 주차 시간 계산
                int parkingTime = nowTime - inTimeMap.get(carNum);
                // 입차 정보 삭제
                inTimeMap.remove(carNum);
                // 누적 주차 시간 업데이트
                totalParkingTimeMap.put(carNum, totalParkingTimeMap.getOrDefault(carNum, 0) + parkingTime);
            }
        }

        // 하루가 끝나는 시간 (23:59)을 분 단위로 변환
        int endTime = changeHourToMin("23:59");
        for (String carNum : inTimeMap.keySet()) {
            // 출차하지 않은 차량의 누적 주차 시간 계산
            int parkingTime = endTime - inTimeMap.get(carNum);
            // 누적 주차 시간 업데이트
            totalParkingTimeMap.put(carNum, totalParkingTimeMap.getOrDefault(carNum, 0) + parkingTime);
        }

        int[] answer = new int[totalParkingTimeMap.size()];
        int idx = 0;
        for (int totalParkingTime : totalParkingTimeMap.values()) {
            // 누적 주차 시간에서 기본 주차 시간을 뺀 값 (음수 값은 0으로 처리)
            int time = Math.max(totalParkingTime - fees[0], 0);

            answer[idx++] = fees[1] + (int) Math.ceil(time / (double) fees[2]) * fees[3];
        }

        return answer;
    }
}
