package programmers_basic;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 인덱스바꾸기 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120895
    문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때,
    my_string에서 인덱스 num1과 인덱스 num2에 해당하는 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.

    */

    public static void main(String[] args) {
        String my_string = "hello";
        int num1 = 1;
        int num2 = 2;
        System.out.println(solutionWithStream(my_string, num1, num2));
    }

    public static String solution(String my_string, int num1, int num2) {
        char[] ch = my_string.toCharArray();

        ch[num1] = my_string.charAt(num2);
        ch[num2] = my_string.charAt(num1);

        return String.valueOf(ch);
    }

    public static String solutionWithStream(String my_string, int num1, int num2) {
        List<String> list = Arrays.stream(my_string.split("")).collect(Collectors.toList());

        Collections.swap(list, num1, num2);
        return String.join("", list);
    }
}
