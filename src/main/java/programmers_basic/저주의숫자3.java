package programmers_basic;

public class CursedNumberThree {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120871

     */

    public static void main(String[] args) {
        CursedNumberThree sol = new CursedNumberThree();
        System.out.println(sol.solution(5));
    }

    public int solution(int n) {
        int answer = n;
        int i = 1;
        while (i <= answer) {
            if ((i % 3 == 0) || String.valueOf(i).contains("3")) {
                answer++;
            }
            i++;
        }
        return answer;
    }
}
