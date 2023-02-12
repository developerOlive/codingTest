package Array;

import java.util.Arrays;

public class x만큼간격이있는n개의숫자 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/12954

    함수 solution은 정수 x와 자연수 n을 입력 받아,
    x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
    다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.

     */

    public static void main(String[] args) {
        x만큼간격이있는n개의숫자 sol = new x만큼간격이있는n개의숫자();
        int x = 2;
        int n = 5;
        System.out.println(Arrays.toString(sol.solution(x, n)));
    }

    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int num = x;

        for (int i=0; i< answer.length; i++) {
            answer[i] = num;
            num += x;
        }

        return answer;
    }

    public long[] solution2(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + x;
        }

        return answer;

    }
}
