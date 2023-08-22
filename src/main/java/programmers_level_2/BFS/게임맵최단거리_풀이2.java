package programmers_level_2.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리_풀이2 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/1844
    */
    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};

        System.out.println(solution(maps));
    }

    public static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int solution(int[][] maps) {
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Node> queue = new LinkedList();

        int[][] count = new int[maps.length][maps[0].length];

        queue.add(new Node(0, 0));
        count[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowCount = count[now.c][now.r];

            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(now.r + move[i][0], now.c + move[i][1]);

                // 맵밖으로 나갈때
                if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r == maps[0].length || nextNode.c == maps.length) {
                    continue;
                }

                // 벽에 부딪힐때
                if (maps[nextNode.c][nextNode.r] == 0) {
                    continue;
                }

                count[nextNode.c][nextNode.r] = nowCount + 1;
                // 이미 지난길은 벽으로 만들어버리기
                maps[nextNode.c][nextNode.r] = 0;
                queue.add(nextNode);
            }
        }

        int answer = count[maps.length - 1][maps[0].length - 1];
        if (answer == 0) {
            return -1;
        }

        return answer;
    }
}
