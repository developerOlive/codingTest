package etc;

public class NumberAndAdditionOfFactors {

    /*
    (문제) 약수의 개수와 덧셈
    https://school.programmers.co.kr/learn/courses/30/lessons/77884

    두 정수 left와 right가 매개변수로 주어집니다.
    left부터 right까지의 모든 수들 중에서,
    약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

    (예시)
    left : 13
    right : 17
    result : 43 (13+14+15-16+17)
     */

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            // 제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            // 제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int left = 13;
        int right = 17;

        System.out.println(solution(left, right));
    }
}
