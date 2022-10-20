package Hash;

import java.util.HashSet;

public class TakeTwoAndAdd {

    /*
    (문제) 두 개 뽑아서 더하기 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/68644

    정수 배열 numbers가 주어집니다.
    numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
     */
    public int[] solution_with_hash(int[] numbers) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        TakeTwoAndAdd sol = new TakeTwoAndAdd();
        int[] numbers = {5, 0, 2, 7};
        System.out.println(sol.solution_with_hash(numbers));
    }
}
