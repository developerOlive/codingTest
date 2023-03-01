package programmers_basic;

public class 문자열뒤집기 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120822
    문자열 my_string이 매개변수로 주어집니다.
    my_string을 거꾸로 뒤집은 문자열을 return하도록 solution 함수를 완성해주세요.
     */

    public static void main(String[] args) {
        String myString = "jaron";
        System.out.println(solution(myString));
    }

    public static String solution(String myString) {
        return new StringBuilder(myString).reverse().toString();
    }
}
