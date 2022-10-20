package Array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solve(height));
    }

    public static int solve(int[] height) {
        int result = 0;
        if (height == null || height.length <= 2) {
            return result;
        }

        // 1. leftMax[]
        int length = height.length; // 12
        int[] left = new int[length];
        int[] right = new int[length];

        int max = height[0];
        left[0] = height[0];

        for (int i = 1; i < length; i++) {
            if (height[i] < max) {
                left[i] = max;
            } else {
                left[i] = height[i];
                max = height[i];
            }
        }
        print(left);


        // 2. rightMax[]
        max = height[length - 1];
        right[length - 1] = height[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            if (height[i] < max) {
                right[i] = max;
            } else {
                right[i] = height[i];
                max = height[i];
            }
        }
        print(right);

        // 3. min() - height
        for (int i = 0; i < length; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        return max;
    }

    public static void print(int[] left) {
        for (int i = 0; i < left.length; i++) {
            System.out.println("순서 : " + i + " / 값 : " + left[i]);
        }
    }
}
