package programmers_basic;

import java.util.Arrays;

public class 배열두배만들기 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120809

    정수 배열 numbers가 매개변수로 주어집니다.
    numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.
     */

    public static void main(String[] args) {

        System.out.println();
    }

    public static int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(n -> n * 2).toArray();
    }
}
