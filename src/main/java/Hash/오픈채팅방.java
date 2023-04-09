package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/42888

     */

    public static void main(String[] args) {
        String[] record ={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    private static String[] solution(String[] record) {
        HashMap<String, String> nickName = new HashMap<>();
        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        for (String s : record) {
            String[] split = s.split(" ");
            if (split.length == 3) {
                nickName.put(split[1], split[2]);
            }
        }

        ArrayList<String> answer = new ArrayList<>();

        for (String s : record) {
            String[] split = s.split(" ");
            if (msg.containsKey(split[0])) {
                answer.add(nickName.get(split[1]) + msg.get(split[0]));
            }
        }

        return answer.toArray(new String[0]);
    }
}
