package programmers_basic;

import java.util.*;

public class 전국대회선발고사 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/181851

    0번부터 n - 1번까지 n명의 학생 중 3명을 선발하는 전국 대회 선발 고사를 보았습니다.
    등수가 높은 3명을 선발해야 하지만, 개인 사정으로 전국 대회에 참여하지 못하는 학생들이 있어
    참여가 가능한 학생 중 등수가 높은 3명을 선발하기로 했습니다.

    각 학생들의 선발 고사 등수를 담은 정수 배열 rank와
    전국 대회 참여 가능 여부가 담긴 boolean 배열 attendance가 매개변수로 주어집니다.
    전국 대회에 선발된 학생 번호들을 등수가 높은 순서대로 각각 a, b, c번이라고 할 때
    10000 × a + 100 × b + c를 return 하는 solution 함수를 작성해 주세요.
    */

    public static void main(String[] args) {
        int[] rank = {3, 7, 2, 5, 4, 6, 1};
        boolean[] attendance = {false, true, true, true, true, false, false};
        System.out.println(solution(rank, attendance));
    }

    public static int solution(int[] rank, boolean[] attendance) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < rank.length; i++) {
            // 참여 가능여부가 true인 경우만, answer list에 등수를 저장함
            if (attendance[i]) {
                answer.add(rank[i]);
            }
        }
        Collections.sort(answer);

        return 10000 * Participant(0, rank, answer) +
                100 * Participant(1, rank, answer) +
                Participant(2, rank, answer);
    }

    public static int Participant(int idx, int[] rank, List<Integer> answer) {
        return findIndex(rank, answer.get(idx));
    }

    // 전체 등수를 저장한 rank 배열에서, answer[0]에 있는 값과 똑같은 경우 어떤 index인지 찾음
    public static int findIndex(int[] rank, int target) {
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
