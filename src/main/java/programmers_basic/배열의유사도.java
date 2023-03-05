package programmers_basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class 배열의유사도 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120903
    두 배열이 얼마나 유사한지 확인해보려고 합니다.
    문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return하도록 solution 함수를 완성해주세요.
     */

    public static void main(String[] args) {
        String[] s1 = {"a", "b", "c"};
        String[] s2 = {"com", "b", "d", "p", "c"};
        System.out.println(solution(s1, s2));
    }

    public static int solution(String[] s1, String[] s2) {
        return (int) Arrays.stream(s1).map(s -> Arrays.stream(s2)
                                                      .collect(Collectors.toList())
                                                      .contains(s))
                                      .filter(b -> b).count();
    }

    public static int solution2(String[] s1, String[] s2) {
        int answer = 0;
        HashSet<String> set = new HashSet<>(List.of(s1));
        for (String s : s2) {
            if (set.contains(s)) {
                answer++;
            }
        }
        return answer;
    }
}
