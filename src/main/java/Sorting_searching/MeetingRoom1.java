package Sorting_searching;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom1 {

    /*
    (문제)
    미팅시간 배열이 주어집니다.
    intervals[i] = [ 회의 startTime, 회의 endTime ]
    intervals 배열을 이용하여 사람들이 모든 회의에 참석할 수 있는지 boolean으로 리턴하세요.

    (예시)
    input : intervals = [ [5,10], [16,20], [0,30] ]
    output : false

    input : intervals = [ [6,10], [1,3] ]
    output : true

    [ 문 제 분 석 ]
    1. start 시간으로 sorting
    2. for문 수행하다가 start, end 시간을 비교
    3. 전 미팅.end > 현재미팅.start 인 경우 회의실이 하나 더 필요

    [ 코 딩 화 ]
    1. 자바 Arrays sorting 필요
    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

    2. 전미팅.end > 현재미팅.start
    이차원 배열 사용
    첫번째 배열을 빼서, 두번째부터 비교
    end = intervals[0][1]
    */

    public static void main(String[] args) {

        MeetingRoom1 meetingRoom = new MeetingRoom1();
        int[][] intervals = {{5, 10}, {16, 20}, {0, 30}};
//        int[][] intervals = {{7,10}, {2,4}};
        System.out.println(meetingRoom.solve(intervals));
    }

    public boolean solve(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return true;
        }

        // 1. start time으로 sorting
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // 0번째 인자로 오름차순
        System.out.println("===========");
        print(intervals);

        // 2. for
        int preEndTime = intervals[0][1]; // 이전 배열의 endTime 시간
        for (int i = 1; i < intervals.length; i++) {
            // 앞전 회의실이 끝나는 시간과, 그 다음에 시작하려는 회의 시간을 비교하는 부분
            // (예) 앞전 회의실이 끝나는 시간이 30분이고, 내가 시작하려는 시간이 5분이면 사용 불가
            if (intervals[i][0] < preEndTime) {
                return false;
            }
            preEndTime = intervals[i][1];
        }

        return true;
    }

    private void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.println(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
