package Sorting_searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {
    /*

    (문제)
    정수 배열 nums와 정수 k가 주어지면 배열에서 k번째로 큰 요소를 반환합니다.
    단, k번째로 큰 요소는 정렬 후 값에 대한 가장 큰 요소가 아닌, 유일한 순서 요소입니다.

    (예시)
    input nums : [2, 3, 1, 5, 6, 4]
    k = 2
    output : 5

    input nums : [3, 2, 3, 1, 2, 4, 5, 5, 6]
    k = 4
    output : 4

    [ 문 제 분 석 ]
    input nums = [2, 3, 1, 5, 6, 4]
    k = 2
    1. pq를 이용해 사이즈 2를 유지하면
    2. 결국 5, 6 만 남게 된다.

    */

    public static void main(String[] args) {
        KthLargestElementInAnArray a = new KthLargestElementInAnArray();

        int[] nums = { 2, 3, 1, 5, 6, 4};
        int k = 2;
        System.out.println(a.solve(nums, k));
        System.out.println(a.solve_pq_asc(nums, k));
        System.out.println(a.solve_pq_desc(nums, k));
    }

    public int solve(int[] nums, int k) {
        Arrays.sort(nums); // 1, 2, 3, 4, 5, 6
        int n = nums.length; // 6

        return nums[n-k]; // 1, 2, 3, 4, 5, 6 중 | 4번방
    }


    /*
    PriorityQueue란 우선순위 큐로써, 우선순위가 높은 데이터가 먼저 나가는 자료구조이다.
    내부구조가 힙으로 구성되어 있기에 시간 복잡도는 O(NLogN)이다.
    우선순위 큐에 들어가는 원소는 비교가 가능한 기준이 있어야한다.
     */

    // ======================== 오름차순으로 푸는 경우 ========================
    public int solve_pq_asc (int[] nums, int k) {

        // 1. asc(오름차순), minHeap (작은 값이 맨 위에)
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        // 2.
        for (int i : nums) {
            priorityQueue.offer(i); // 우선순위 큐에 값을 추가할 때 offer()
            if (priorityQueue.size() > k) { // 우선순위 큐의 개수 구할 때 size()
                priorityQueue.poll(); // 우선순위 큐에서 값을 제거할 때 poll()
            }
        }

        return priorityQueue.peek(); // 가장 우선순위가 높은 값을 참조할 때 peek()
    }

    public int solve_pq_desc(int[] nums, int k) {

        // ======================== 내림차순으로 푸는 경우 =======================
        int answer = 0;

        // 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Priority Queue에 배열 원소들을 모두 넣는다.
         for (int i=0; i<nums.length; i++) {
             pq.offer(nums[i]);
         }

        // k개 꺼내서, 마지막으로 꺼낸 원소를 반환한다.
         while (k > 0) {
             answer = pq.poll();
             System.out.println("answer : " + answer);
             k--;
         }

         return answer;
    }
}
