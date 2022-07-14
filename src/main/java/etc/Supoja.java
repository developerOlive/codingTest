package etc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Supoja {
    /*
    (문제) 수포자 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/42840

    수포자는 수학을 포기한 사람의 준말입니다.
    수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
    수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

    1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
    3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
    가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
     */

    public int[] solution(int[] answers) {

        int[] student1 = new int[]{1, 2, 3, 4, 5};
        int[] student2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int studentAnswer1 = 0;
        int studentAnswer2 = 0;
        int studentAnswer3 = 0;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                studentAnswer1++;
            }
            if (answers[i] == student2[i % student2.length]) {
                studentAnswer2++;
            }
            if (answers[i] == student3[i % student3.length]) {
                studentAnswer3++;
            }
        }

        int topScore = Math.max(studentAnswer1, Math.max(studentAnswer2, studentAnswer3));

        if (topScore == studentAnswer1) {
            result.add(1);
        }
        if (topScore == studentAnswer2) {
            result.add(2);
        }
        if (topScore == studentAnswer3) {
            result.add(3);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Supoja sol = new Supoja();
        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(sol.solution(answers)));
    }
}
