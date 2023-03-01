package programmers_basic;

public class 특정문자제거하기 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120826
    문자열 my_string과 문자 letter이 매개변수로 주어집니다.
    my_string에서 letter를 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
     */

    public static void main(String[] args) {
        String myString = "abcdef";
        String letter = "f";
        System.out.println(solution(myString, letter));
    }

    public static String solution(String myString, String letter) {
        return myString.replace(letter, "");
    }
}
