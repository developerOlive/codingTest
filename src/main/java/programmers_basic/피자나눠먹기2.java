package programmers_basic;

public class 피자나눠먹기2 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120815
    머쓱이네 피자가게는 피자를 여섯 조각으로 잘라 줍니다.
    피자를 나눠먹을 사람의 수 n이 매개변수로 주어질 때, n명이 주문한 피자를 남기지 않고 모두 같은 수의 피자 조각을 먹어야 한다면
    최소 몇 판을 시켜야 하는지를 return 하도록 solution 함수를 완성해보세요.
     */

    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return LCM(n, 6) / 6;
    }

    /*
    기본 조각수 (6조각)와 주어진 n으로 모두가 한조각씩 먹으면서도
    피자가 남지 않게 하는 최소한의 조각수를 구하면(즉, 최소공배수) 최소 피자 판 수를 구할 수 있다.

    1. 최소공배수는 두 수의 곱을 두 수의 최대공약수로 나눈 값으로 나타낼 수 있다.
    3. 1번의 과정을 위해 최대공약수를 구한다.
     */

    // 최소공배수
    public static int LCM(int num1, int num2) {
        return num1 * num2 / GCD(num1, num2);
    }

    // 최대공약수
    public static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return GCD(num2, num1 % num2);
    }


}
