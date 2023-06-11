package programmers_level_2.String;

public class JadenCase문자열만들기 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/12951

    JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다.
    단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다.
    문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴
    */

    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.toLowerCase().split("");

        boolean flag = true;

        for (String word : words) {
            answer.append(flag ? word.toUpperCase() : word);
            flag = word.equals(" ");
        }

        return answer.toString();
    }
}
