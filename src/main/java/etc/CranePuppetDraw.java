package etc;

import java.util.Stack;

public class CranePuppetDraw {

    /*
    (문제) 크레인 인형뽑기 게임 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/64061


    1) 바구니 역할을 해줄 stack을 준비하고, 0을 넣는다.
        - 0을 넣는 이유는 stack의 맨 위 값과 비교해야하는데 아무것도 없으면 오류가 나기 때문이다.
    2) moves의 길이만큼 for문을 돌린다.
        - board의 길이만큼 for문을 돌린다. (해당 라인에서 인형을 뽑기 위해)
            - 만약 board[j][move - 1]이 0이라면 인형이 없는 것이기 때문에 넘어간다.
            - 0이 아니라면
                - Stack(바구니)의 가장 윗 요소와 board[j][move - 1]가 같은지 비교한다.
                - 같다면 인형이 터지는 것이기 때문에 Stack에 pop을 하고 answer에 2를 더한다.
                - 다르다면 Stack에 board[j][move - 1]를 push한다.
    3) answer를 리턴한다.
     */

    public static void main(String[] args) {
        CranePuppetDraw sol = new CranePuppetDraw();
        int[][] board = {{0, 0, 0, 0, 0},
                         {0, 0, 1, 0, 3},
                         {0, 2, 5, 0, 1},
                         {4, 2, 4, 4, 2},
                         {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(sol.solve(board, moves));
    }

    public int solve(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int move : moves) {
            for (int j = 0; j < board.length; j++)
                if (board[j][move - 1] != 0) {
                    if (stack.peek() == board[j][move - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][move - 1]);
                    }
                    board[j][move - 1] = 0;
                    break;
                }
        }
        return answer;
    }
}
