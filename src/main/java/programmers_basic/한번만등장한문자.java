package programmers_basic;

import java.util.*;

public class 한번만등장한문자 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120896

    문자열 s가 매개변수로 주어집니다.
    s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.
    한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
    */

    public static void main(String[] args) {
        System.out.println(solution("hello"));
    }

    public static String solution(String s) {

        StringBuilder answer = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : s.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(String::compareTo);

        for (String key : keyList) {
            if (map.get(key) == 1) {
                answer.append(key);
            }
        }

        return answer.toString();
    }
}
