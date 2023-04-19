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
        System.out.println(solution2("hello"));
    }

    // 시간복잡도 : O(n log n)
    public static String solution(String s) {

        StringBuilder answer = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();

        for (String str : s.split("")) { // O(n)
            map.put(str, map.getOrDefault(str, 0) + 1); // O(1)
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(String::compareTo); // O(n log n)

        for (String key : keyList) {
            if (map.get(key) == 1) {
                answer.append(key); // O(n)
            }
        }

        return answer.toString();
    }

    // 시간복잡도 : O(n)
    public static String solution2(String s) {

        int[] alpha = new int[26]; // 26 : 알파벳 소문자 수

        for (char c : s.toCharArray()) {
            /*
             alpha[c - 'a']++; 란?
             문자 c가 등장한 횟수를 기록하는 배열 alpha에서 c의 인덱스에 해당하는 값에 1을 더하는 것입니다.
             예를 들어, c가 소문자 알파벳 'a'일 경우, c - 'a'는 0이 되며, alpha[0]의 값을 1 증가시킵니다.
             만약 c가 'b'일 경우, c - 'a'는 1이 되며, alpha[1]의 값을 1 증가시킵니다.
             이런 식으로 문자열을 순회하면서 각 알파벳의 등장 횟수를 기록하는 것입니다.
             */
            alpha[c - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (alpha[i] == 1) {
                /*answer.append((char) (i + 'a')); 란?
                answer.append((char) (i + 'a'))는 등장 횟수가 1인 알파벳을 answer 문자열에 추가하는 것입니다.
                i + 'a'는 알파벳 소문자의 아스키 코드 값으로, i가 0부터 25까지 증가하면서 answer에 추가할 알파벳을 결정합니다.
                예를 들어, i가 0일 때는 'a'를 추가하고, i가 1일 때는 'b'를 추가하는 식으로 결정됩니다.
                (char)는 (i + 'a')를 아스키 코드 값에서 문자로 변환하는 것입니다.
                따라서 answer.append((char) (i + 'a'))는 등장 횟수가 1인 알파벳을 answer에 추가하는 것을 의미합니다.
                 */
                answer.append((char) (i + 'a'));
            }
        }
        return answer.toString();
    }


}
