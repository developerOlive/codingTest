package Array;

import java.util.HashMap;
import java.util.Map;

public class 투썸 {

    /*
    (문제)
    정수의 배열 nums와 정수 target이 주어집니다.
    배열 nums에서 두 숫자의 값을 더하여, target 값과 동일할 경우 두 숫자의 인덱스를 리턴합니다.

    각 입력에 정확히 하나의 솔루션이 있다고 가정하며,
    동일한 요소를 두 번 사용할 수 없습니다.
    또한, 시간복잡도 O(n)으로 수행하세요. = 이중 for문 사용 불가

    (예시)
     nums = [ 2, 8, 11, 14 ]
     target = 16
     output = [ 1, 4 ]

     [ 문 제 분 석 ]
     { 2, 8, 11, 14 }
     1. for 돌려서 target과 비교
     2. 16 - 2 = 11
     3. Map (숫자, 방번호)
     4. 방번호만 리턴 int[]
     */

    public static void main(String[] args) {

        투썸 twoSum = new 투썸();
        int[] nums = {2, 8, 11, 14};
        int target = 16;

        int[] result = twoSum.solve_map(nums, target);
        for (int i : result) {
            System.out.println(i + " ");
        }
    }

    // O(n^2) 방법 = 2중 for문 사용
    public int[] solve_for(int[] nums, int target) {

        int length = nums.length; // 배열의 길이

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{0, 0};
    }


    // O(n) 방법 = 2중 for문 미사용 (Map 이용)
    public int[] solve_map(int[] nums, int target) {

        // 1. data structure
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        // 2. for + map
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int val = map.get(nums[i]); // (2) for문을 돌다가 14를 만나면 value인 0을 추출
                result[0] = val + 1; // 0 + 1
                result[1] = i + 1; //
            } else {
                map.put(target - nums[i], i); // (1) 14(16-2) , 0
            }
        }

        return result;
    }
}
