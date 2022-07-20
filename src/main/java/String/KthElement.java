package String;

import java.util.Arrays;

public class KthElement {

    /*
    (문제) K번째 수 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/42748

    배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

    예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

    array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
    1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
    2에서 나온 배열의 3번째 숫자는 5입니다.
    배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
    commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.


    (예시)
    array : [1, 5, 2, 6, 3, 7, 4]
    commands : [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
    return : [5, 6, 3]
     */

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int index = 0;

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            // public static int [] copyOfRange (int [] original_array, int from_index, int to_index)
            // original_array - 복사할 원본 배열 (arr)
            // from_index - 원본 배열에서 복사할 범위의 시작 인덱스
            // to_index - 원본 배열에서 복사할 범위의 끝 인덱스
            int[] temp = Arrays.copyOfRange(array, i-1, j);

            Arrays.sort(temp);

            answer[index] = temp[k-1];

            index++;
        }

        return answer;
    }

    public static void main(String[] args) {
        KthElement sol = new KthElement();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(sol.solution(array, commands)));
    }
}
