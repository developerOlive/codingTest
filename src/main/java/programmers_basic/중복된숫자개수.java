package programmers_basic;

import java.util.Arrays;

public class 중복된숫자개수 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120583
    정수가 담긴 배열 array와 정수 n이 매개변수로 주어질 때,
    array에 n이 몇 개 있는 지를 return 하도록 solution 함수를 완성해보세요.
     */

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 3, 4, 5};
        int n = 1;
        System.out.println(solution(array, n));
    }

    public static int solution(int[] array, int n) {
        return (int) Arrays.stream(array).filter(a -> a == n).count();
    }
}
