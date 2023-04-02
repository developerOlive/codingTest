package programmers_basic;

import java.util.stream.Collectors;

public class 대문자와소문자 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120893
    문자열 my_string이 매개변수로 주어질 때,
    대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.
    */

    public static void main(String[] args) {
        String my_string = "abCdEfghIJ";
        System.out.println(solution2(my_string));
    }

    public static String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<my_string.length(); i++) {
            if (Character.isUpperCase(my_string.charAt(i))) {
                answer.append(Character.toLowerCase(my_string.charAt(i)));
            } else {
                answer.append(Character.toUpperCase(my_string.charAt(i)));
            }
        }
        return answer.toString();
    }

    public static String solution2(String my_string) {
        return my_string.chars()
                .mapToObj(operand -> String.valueOf((char) (Character.isLowerCase(operand)
                        ? Character.toUpperCase(operand)
                        : Character.toLowerCase(operand))))
                .collect(Collectors.joining());
    }

}
