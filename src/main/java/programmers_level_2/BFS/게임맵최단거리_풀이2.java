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
        // 상, 하, 좌, 우 순서로 이동할 수 있는 좌표 변화
        int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // 큐를 이용하여 탐색할 정점을 순서대로 처리하기 위해 큐 생성
        Queue<Node> queue = new LinkedList();

        // 각 정점까지의 최단 거리를 저장하는 배열
        int[][] count = new int[maps.length][maps[0].length];

        // 시작 지점을 큐에 추가하고 해당 위치를 방문했다고 표시
        queue.add(new Node(0, 0));
        count[0][0] = 1;

        /*
        BFS 알고리즘에서는 큐에 탐색해야 할 정점을 추가하고, 탐색을 진행할 때마다 큐에서 하나씩 정점을 꺼내서 처리하게 됩니다.
        이때 큐가 비어있게 되면 모든 정점을 처리한 것이므로 BFS 탐색이 종료됩니다.
         */
        while (!queue.isEmpty()) {

            // BFS 알고리즘에서는 큐에 넣은 정점을 순서대로 처리하면서 그 정점에서 갈 수 있는 다음 정점들을 큐에 추가해 나가는데,
            // 이때 처리되는 정점은 큐에서 poll 메서드를 통해 꺼내오게 됩니다.
            // 이렇게 하면 큐에는 항상 현재 처리해야 할 정점들이 순서대로 들어있게 되며, BFS 의 특성상 먼저 추가된 정점들부터 순차적으로 처리됩니다.
            Node now = queue.poll();
            int nowCount = count[now.c][now.r];

            for (int i = 0; i < 4; i++) {
                Node nextNode = new Node(now.r + move[i][0], now.c + move[i][1]);

                // 맵 밖으로 나갈때
                if (nextNode.r < 0 || nextNode.c < 0 || nextNode.r == maps[0].length || nextNode.c == maps.length) {
                    continue;
                }

                // 벽에 부딪힐때
                if (maps[nextNode.c][nextNode.r] == 0) {
                    continue;
                }

                count[nextNode.c][nextNode.r] = nowCount + 1;
                // 이미 지난길은 벽으로 변경
                maps[nextNode.c][nextNode.r] = 0;
                queue.add(nextNode);
            }
        }

        // 맵의 마지막 위치에 해당하는 정점의 최단 거리
        int answer = count[maps.length - 1][maps[0].length - 1];

        // 결과 반환 (도달할 수 없는 경우 -1 반환)
        return answer == 0 ? -1 : answer;
    }
}
