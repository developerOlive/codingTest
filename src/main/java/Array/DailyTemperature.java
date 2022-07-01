package Array;

import java.util.Stack;

public class DailyTemperature {

    /*
    (문제)
    일일 온도를 나타내는 int 배열이 주어집니다.
    더 따듯한 날씨의 날을 얻기 위해 해당날짜 이후에 기다려야 하는 날짜의 수를 배열로 리턴하세요.
    더 따듯한 날이 오지 않는다면 0을 리턴하세요.


    (예시)
    73 , 74 , 75 , 71 , 69 , 72 , 76, 73

    1. 73도에서는 1일 후 - 74
    2. 74도에서는 1일 후 - 75
    3. 75도에서는 4일 후 - 76
    4. 71도에서는 2일 후 - 72
    5. 69도에서는 1일 후 - 72
    6. 72도에서는 1일 후 - 76
    7. 76, 73에서는 없기 때문에 0

    * output : 1, 1, 4, 2, 1, 1, 0, 0


    [ 문 제 분 석 ]
    1. for문을 돌린다.
    2. 73이 나온 상태에서 74를 만나야 되는 상황
    3. 73과 74를 비교해서 73<74기 때문에, 인덱스 차이 1을 결과값에 저장

    1. for문을 돌린다.
    2. 75가 나온 시점에 71, 68, 72, 76을 만나야 되는 상황
       75보다 큰 수가 나올 때까지 while문 실행
       while문 빠져 나오는 시점, max-i 가 됨
    3. 75와 76을 비교해서 75<76이기 때문에, 인덱스 차이 4를 결과값에 저장

     */

    public static void main(String[] args) {

        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};

//        int[] result_for = solve_for(nums);
//        System.out.println("===== result1 =====");
//        for (int i : result_for) {
//            System.out.println(i + " ");
//        }

        int[] result_stack = solve_stack(nums);
        System.out.println("===== result2 =====");
        for (int i : result_stack) {
            System.out.println(i + " ");
        }
    }

    // ======================= 1번 풀이 (for문 2번 돌려서 풀이) =======================
    public static int[] solve_for(int[] temperature) {
        // 1. data structure
        int length = temperature.length;
        int[] result = new int[length]; // 8개
        int count = 0, j;

        // 2. for
        for (int i = 0; i < length; i++) {
            for (j = i + 1; j < length - 1; j++) {
                if (temperature[i] < temperature[j]) {
                    count++;
                    break;
                } else {
                    count++;
                }
            }

            if (j == temperature.length) {
                result[i] = 0;
            } else {
                result[i] = count;
            }

            count = 0;
        }

        return result;
    }

    // ======================= 2번풀이 (스택 이용) ======================
    public static int[] solve_stack(int[] temperature) {
        // 1. data structure
        int length = temperature.length; // 8
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperature[stack.peek()] < temperature[i]) { // .peek() : stack의 마지막 push값 확인
                System.out.println("temperature[i] : " + temperature[i]);
                int index = stack.pop(); // .pop() : stack의 마지막 push값 제거
                System.out.println("index : " + index);
                System.out.println("i : " + i);
                result[index] = i - index;
            }
            stack.push(i); // .push(i) : stack에 i 추가
        }

        return result;
    }
}
