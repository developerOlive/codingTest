package TwoDArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ranking {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120882

    영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다.
    영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때,
    영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.

    (예시)
    score : [[80, 70], [90, 50], [40, 70], [50, 80]]
    result : [1,2,4,3]
     */

    public static void main(String[] args) {
        int[][] score = { {80,70}, {90,50}, {40,70}, {50,60}};
        Ranking sol = new Ranking();
        System.out.println(Arrays.toString(sol.solution(score)));
    }

    public int[] solution(int[][] score) {
        List<Integer> scoreList = new ArrayList<>();

        for (int[] t : score) {
            scoreList.add(t[0] + t[1]);
        }
        scoreList.sort(Comparator.reverseOrder());

        int[] answer = new int[score.length];
        for (int i=0; i<score.length; i++) {
            answer[i] = scoreList.indexOf(score[i][0] + score[i][1]) + 1;
        }

        return answer;
    }
}
