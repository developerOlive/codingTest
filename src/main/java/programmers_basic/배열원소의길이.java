package programmers_basic;

import java.util.Arrays;

public class 배열원소의길이 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120854

    문자열 배열 strList 매개변수로 주어집니다.
    strList 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.
     */

    public static void main(String[] args) {
        String[] strList = {"We", "are", "the", "world!"};
        System.out.println(Arrays.toString(solution(strList)));
    }

    public static int[] solution(String[] strList) {
        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
}
