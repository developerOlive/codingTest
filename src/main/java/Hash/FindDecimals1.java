package Hash;

public class FindDecimals1 {

    /*
    (문제) 소수찾기 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/12921

    1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
    소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
    (1은 소수가 아닙니다.)

    (예시)
    n : 10
    result : 4 (2,3,5,7 소수가 4개 존재)
     */

    public static void main(String[] args) {
        System.out.println(solve(10));
    }

    public static int solve(int n) {
        int answer = 0;
        int count = 0;


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
            }
            if (count == 2) answer++;
            count = 0;
        }

        return answer;
    }
}
