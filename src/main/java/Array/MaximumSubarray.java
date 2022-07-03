package Array;

public class MaximumSubarray {

    /*
    (문제)
    정수배열 nums가 주어지면, 합계가 가장 큰 연속 하위배열 (최소 하나 숫자포함)을 찾아서 합계를 리턴합니다.

    (예시)
    input : nums = [ -2, 1, -3, 4, -1, 2, 1, -5, 4 ]
    output : 6   ( [4,-1,2,1] )

    input : nums = [ 10, 10, -3, 10, 10 ]
    output : 37 ( [10, 10, -3, 10, 10] )

     */

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solve(nums));
    }

    public static int solve(int[] nums) {

        int currentMax = nums[0];
        int allMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            System.out.println("nums[" + i + "] " + nums[i] + " | nums[" + i + "] + currentMax : " + (nums[i] + currentMax));

            currentMax = Math.max(nums[i], nums[i] + currentMax);
            allMax = Math.max(allMax, currentMax);

            System.out.println("currentMax : " + currentMax + " / allMax : " + allMax);
        }

        return allMax;
    }
}
