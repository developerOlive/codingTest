package Hash;

import java.util.HashMap;
import java.util.Map;

public class 신고결과받기 {

    /*

    https://school.programmers.co.kr/learn/courses/30/lessons/92334

    (문제) 신고 결과 받기
    신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.

    각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
    신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
    한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
    k번 이상 신고된 유저는 게시판 이용이 정지되며,
    해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
    유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
    
    이용자의 ID가 담긴 문자열 배열 id_list, 
    각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report, 
    정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때, 
    각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.

    (예시)
    id_list : ["muzi", "frodo", "apeach", "neo"]
    report : ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
    k : 2
    result : [2, 1, 1, 0]

     */

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        int[] result = solution(id_list, report, k);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }

    public static int[] solution(String[] idList, String[] report, int k) {

        // 신고정보맵 (신고당한 사람, 신고당한 횟수)
        Map<String, Integer> reportedList = new HashMap<>();
        for (String r : report) {
            String reportedTarget = r.split(" ")[1];
            reportedList.put(reportedTarget, reportedList.getOrDefault(reportedTarget, 0) + 1);
        }

        int[] result = new int[idList.length];
        for (int i = 0; i < idList.length; i++) {
            String userId = idList[i];
            int count = 0;

            for (String r : report) {
                if (r.startsWith(userId + " ") && reportedList.getOrDefault(r.split(" ")[1], 0) >= k) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
