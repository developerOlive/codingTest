package StreamApi;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicateCharacters {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120888

    문자열 my_string이 매개변수로 주어집니다.
    my_string에서 중복된 문자를 제거하고 하나의 문자만 남긴 문자열을 return하도록 solution 함수를 완성해주세요.
     */

    public static void main(String[] args) {
        String myString = "people";
        System.out.println(solution(myString));
    }

    public static String solution(String myString) {
        return Arrays.stream(myString.split("")).distinct().collect(Collectors.joining());
    }
}
