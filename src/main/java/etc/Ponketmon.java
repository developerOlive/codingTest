package etc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

    /*
    (문제) 폰켓몬 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/1845
     */

public class Ponketmon {

    public static void main(String[] args) {
        Ponketmon sol = new Ponketmon();
        int[] nums = {3, 3, 3, 2, 2, 4};
        System.out.println(sol.solve_with_set(nums));
    }

    public int solve_with_set(int[] nums) {
        int max = nums.length / 2;

        // 1. 중복 제거
        HashSet<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        return Math.min(numSet.size(), max);
    }

    public int solve_with_streamAPI(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen( // stream 요소를 set으로 수집 후, 그 다음 결과를 변환
                        Collectors.toSet(),
                        ponketmons -> Integer.min(ponketmons.size(), nums.length / 2)));
    }
}
