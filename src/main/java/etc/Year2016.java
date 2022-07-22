package etc;

import java.time.LocalDate;

public class Year2016 {

    /*
    (문제) 2016년 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/12901

    2016년 1월 1일은 금요일입니다.
    2016년 a월 b일은 무슨 요일일까요?
    두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
    요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다.
    예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
     */

    public static String solution(int a, int b) {
        return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);
    }

    public static void main(String[] args) {
        Year2016 sol = new Year2016();
        int a = 5;
        int b = 24;

        System.out.println(solution(a,b));

        // ================================
        System.out.println(LocalDate.of(2022,07,11));
        System.out.println(LocalDate.of(2022, 07, 11).getDayOfWeek());
    }
}
