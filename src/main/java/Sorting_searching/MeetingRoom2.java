package Sorting_searching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {

    /*
    (문제)
    미팅 시간 배열이 주어집니다. intervals[i] = [startTime, endTime]
    intervals 배열을 이용하여 사람들이 회의에 참석하려면, 몇 개의 회의실이 필요한지 리턴하세요.

    (예시)
    input : intervals = [ [5,10], [16,20], [0,30] ]
    output : 2

    input : intervals = [ [6,10], [1,3]]
    output : 1

    [ 문 제 분 석 ]
    1. 회의끝 시간이 제일 긴 것을 관리한다.
    앞.end와 뒷.start 시간을 비교해서
    회의실 추가가 필요 없는 것은 하나로 합치고,
    추가가 필요한 것은 큐에 넣는다.

    2. minHeap을 만든다.
     Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]));
     */

    public static void main(String[] args) {
        MeetingRoom2 meetingRoom = new MeetingRoom2();
        int[][] intervals = { {5,10}, {16,20}, {0,30}};
        System.out.println(meetingRoom.solve(intervals));
    }

    public int solve(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->a[0] - b[0]); // 오름차순
        Queue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);

        //2. for pq
        for (int[] arr : intervals) {
            if(queue.isEmpty()) {
                queue.offer(arr);
            } else {
                if (queue.peek()[1] <= arr[0]) {
                    queue.poll();
                }
                queue.offer(arr);
            }
        }
        return queue.size();
    }
}
