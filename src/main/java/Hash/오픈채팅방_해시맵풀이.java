package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방_해시맵풀이 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/42888

     */
    private static String[] solution(String[] record) {
        HashMap<String, String> nickName = new HashMap<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String id = parts[1];
            String nick = parts[2];

            nickName.put(id, nick);
        }

        HashMap<String, String> msgMap = new HashMap<>();
        msgMap.put("Enter", "님이 들어왔습니다.");
        msgMap.put("Leave", "님이 나갔습니다.");

        ArrayList<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] parts = s.split(" ");
            if (msgMap.containsKey(parts[0])) {
                answer.add(nickName.get(parts[1]) + msgMap.get(parts[0]));
            }
        }

        return answer.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] record ={
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(solution(record)));
    }

}
