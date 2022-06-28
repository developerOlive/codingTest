package Sorting_searching;

public class MoveZeros {

    /*
    (문제) 정수배열(nums)이 주어지면,
    0이 아닌 값은 상대적 순서를 유지하고
    nums의 모든 0은 끝으로 이동하게 만드세요.
    (단, 배열의 복사본을 만들지 않아야 함)


    (예시)
    - Input : nums = [ 0, 3, 2, 0, 8, 5 ]
    - Output : [3, 2, 8 , 5, 0, 0 ]

    - Input : nums = [ 0 ]
    - Output : [ 0 ]


    [ 문 제 분 석 ]
    1. 값이 0이 아닌 값을 먼저 배열에 담는다.
    2. Index를 기억한다.
    3. 해당 Index에 0인 값을 넣는다.
     */

    public static void main(String[] args) {

        int[] nums = { 0, 3, 2, 0, 8, 5 };
        int index = 0;

        int n = nums.length; // 6

        // 3, 2, 8, 5 먼저 배열에 저장
        for (int i=0; i<n; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        System.out.println("index : " + index );

        // 3, 2, 8, 5, 0, 0 까지 배열에 저장
        while(index < n) {
            nums[index] = 0;
            index++;
        }

        for (int i: nums) {
            System.out.println("i : " + i);
        }
    }
}
