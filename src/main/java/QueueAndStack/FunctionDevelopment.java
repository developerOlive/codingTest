package QueueAndStack;

import java.util.*;

public class FunctionDevelopment {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/42586

    프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

    또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
    이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

    먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
    각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
    각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
     */

    public static void main(String[] args) {
        FunctionDevelopment sol = new FunctionDevelopment();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        // 각 기능이 개발되기까지 남은 기간
        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) { // peek(): 스택의 가장 위에 있는 항목을 반환한다.
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date); // 해당 큐 맨 뒤에 값 삽입, 값 추가 성공 시 true 반환, 값 추가 실패 시 false 반환
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
