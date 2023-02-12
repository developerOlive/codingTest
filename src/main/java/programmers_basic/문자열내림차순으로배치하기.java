package programmers_basic;

import java.util.Arrays;

public class ArrangeStringInDescendingOrder {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/12917

    문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
    s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
     */

    public String solution1(String s) {
        StringBuilder answer = new StringBuilder();
        char[] str = s.toCharArray();
        Arrays.sort(str);

        for (int i = str.length - 1; i>=0; i--) {
            answer.append(str[i]);
        }

        return answer.toString();
    }

    public String solution2(String s) {
        char[] sol = s.toCharArray();
        Arrays.sort(sol);

        return new StringBuilder(new String(sol)).reverse().toString();
    }

    public static void main(String[] args) {
        ArrangeStringInDescendingOrder sol = new ArrangeStringInDescendingOrder();
        String s = "Zbcdefg";
        System.out.println(sol.solution2(s));
    }

}
