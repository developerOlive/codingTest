package programmers_level_2.BFS;

import java.awt.*;
import java.util.ArrayDeque;

public class 게임맵최단거리 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/1844

    BFS(너비 우선 탐색)를 푸는 포인트
    1. 비어있는 큐, 방문배열, 최단거리(필요한 경우)를 만든다.
    2. 시작 정점을 큐에 넣고, 방문 배열에 방문했음을 저장한다.
    3. 큐에 데이터가 남아있을 때까지 아래 과정을 반복한다.
        (1) 큐에서 정점을 꺼낸다.
        (2) 해당 정점에서 방문 가능한 다음 정점을 큐에 넣는다. (이미 방문한 정점은 제외한다.)
        (2-1) 필요한 경우, 해당 정점이 유효한 정점인지 체크한다.
        (2-2) 필요한 경우, 해당 정점으로 이동 가능한지 체크한다.
        (3) 필요한 경우, 해당 정점의 최단 거리에서 +1을 한 값을 -> 다음 정점의 최단 거리로 저장한다.
        (4) 큐에 정점을 넣으면서 해당 정점에 대해 방문했음을 저장한다. (중요!)
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

    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int solution(int[][] maps) {

        int N = maps.length;
        int M = maps[0].length;

        // 방문을 순서대로 진행하게 할 큐 생성
        ArrayDeque<Node> queue = new ArrayDeque<>();
        // 방문 배열 생성
        boolean[][] visited = new boolean[N][M];
        // 거리 배열 생성
        int[][] dist = new int[N][M];

        queue.addLast(new Node(0, 0));
        visited[0][0] = true;
        dist[0][0] = 1;

        // 큐가 비어있지 않을 때까지 while문 통해 반복
        while (!queue.isEmpty()) {

            // 큐에서 현재 정점을 꺼냄
            Node now = queue.pollFirst();

            // 현재 정점에서 갈 수 있는 다음 정점을 찾아야 함 (상/하/좌/우)
            for (int i = 0; i < 4; i++) {

                int nextRow = now.r + rx[i];
                int nextCol = now.c + ry[i];

                // 맵 밖으로 나가는 경우 예외처리
                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= M) {
                    continue;
                }

                // 갈 수 없는 곳 (벽) 예외처리
                if (maps[nextRow][nextCol] == 0) {
                    continue;
                }

                if (!visited[nextCol][nextRow]) {
                    visited[nextCol][nextRow] = true;
                    queue.addLast(new Node(nextRow, nextCol));
                    dist[nextRow][nextCol] = dist[now.r][now.c] + 1;
                }
            }
        }

        return dist[N-1][M-1] == 0 ? -1 : dist[N-1][M-1];
    }
}
