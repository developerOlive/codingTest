package programmers_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 잘라서배열로저장하기 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120913

    문자열 my_str과 n이 매개변수로 주어질 때,
    my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.
    */

    public static void main(String[] args) {
        String my_str = "abc1Addfggg4556b";
        int n = 6;
        System.out.println(Arrays.toString(solution(my_str, n)));
    }

    public static String[] solution(String my_str, int n) {

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < (my_str.length() / n); i++) {
            answer.add(my_str.substring((n * i), (n * (i + 1))));
        }

        if (my_str.length() % n != 0) {
            answer.add(my_str.substring((my_str.length() / n) * n));
        }

        return answer.toArray(new String[0]);
    }
}
