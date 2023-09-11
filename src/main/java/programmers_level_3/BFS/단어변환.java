package programmers_level_3.BFS;

import java.util.*;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/43163

    두 개의 단어 begin, target과 단어의 집합 words가 있습니다.
    아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

    예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면
    "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

    두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,
    최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

   ------------------------------------------------------------------------------------------------------

    BFS 알고리즘은 시작 단어(begin)로부터 출발하여 목표 단어(target)로 가는 최단 경로를 찾는 것을 목표로 합니다.
    queue에는 현재 탐색 중인 단어가 순차적으로 추가됩니다. 즉, 큐에서 꺼낸 단어를 기준으로 이어진 단어를 탐색합니다.
    각 단계에서 queue에서 꺼낸 단어를 기반으로 가능한 변환 단어를 찾고, 이러한 단어들을 큐에 추가합니다. 동시에 해당 단어들은 wordSet에서 제거됩니다.
    이 과정을 반복하여 BFS 알고리즘이 모든 가능한 경로를 탐색하고, 그 중에서 최단 경로를 찾습니다.
 */
public class 단어변환 {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        Set<String> wordsSet = new HashSet<>(List.of(words));

        if (!wordsSet.contains(target)) {
            return 0; // 변환할 수 없는 경우
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin); // 큐의 제일 끝에 데이터 추가

        int answer = 0;

        while (!queue.isEmpty()) {

            for (int i = 0; i < queue.size(); i++) {
                /*
                    queue 에서 단어를 하나씩 꺼내어 current(현재단어)에 저장
                    BFS 알고리즘에서는 큐에 넣은 정점을 순서대로 처리하면서 그 정점에서 갈 수 있는 다음 정점들을 큐에 추가해 나가는데,
                    이때 처리되는 정점은 큐에서 poll 메서드를 통해 꺼내오게 됩니다.
                    이렇게 하면 큐에는 항상 현재 처리해야 할 정점들이 순서대로 들어있게 되며, BFS 의 특성상 먼저 추가된 정점들부터 순차적으로 처리됩니다.
                 */
                String current = queue.poll(); // 큐의 제일 앞에 있는 데이터 꺼낸 후 큐에서 제거

                if (current.equals(target)) {
                    return answer;
                }

                /*
                    wordsSet의 요소들을 직접 반복하며 변환 가능한 단어를 찾아 큐에 넣는 것이 주요한 내용
                    예를 들어, 현재 단어 current가 "hot"이라고 가정하면,
                    "dot"과 "lot"이 wordsSet에 있는 경우에 "dot"과 "lot"을 찾아 큐에 추가하고
                    동시에 iterator.remove()를 호출하여 wordsSet에서 "dot"과 "lot"을 제거합니다.
                    이렇게 하면 이미 처리한 단어를 중복해서 처리하지 않을 수 있고, BFS를 효율적으로 수행할 수 있게 됩니다.
                 */
                Iterator<String> iterator = wordsSet.iterator();
                while (iterator.hasNext()) {
                    String word = iterator.next();
                    if (canConvert(current, word)) {
                        queue.offer(word); // 큐의 제일 끝에 데이터 추가
                        iterator.remove();
                    }
                }
            }

            answer++;
        }

        return 0;
    }

    public static boolean canConvert(String word1, String word2) {
        int diffCnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }
}
