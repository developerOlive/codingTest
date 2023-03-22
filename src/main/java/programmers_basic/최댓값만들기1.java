package programmers_basic;

import java.util.Arrays;
import java.util.Comparator;

public class 최댓값만들기1 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120847

     */

    public static void main(String[] args) {
        int[] numbers = {0, 31, 24, 10,1, 9};
        System.out.println(solution2(numbers));
    }

    public static int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }

    public static int solution2(int[] numbers) {
        numbers = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        return numbers[0] * numbers[1];
    }
}
