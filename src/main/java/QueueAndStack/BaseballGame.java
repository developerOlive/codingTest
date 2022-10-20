package QueueAndStack;

import java.util.Stack;

public class BaseballGame {

    /*
    (문제)

    (예시)
    input : ["5","-2","4","C","D","9","+","+"]
    output : 27

    1. The sum is : 5
    2. -2 points. The sum is : 3
    3. 4 points. The sum is : 7
    C : 3번 데이터 삭제. The sum is : 3 (stack에서 pop)
    D : 2번의 -2값에 대해 *2를 하여 -4를 얻는다. -4 + 3 = -1 The sum is : -1
    5 : 9 points. The sum is : 8
    6. -4 + 9 = 5 points. The sum is : 13
    7. 9 + 5 = 14 points. The sum is : 27

     */
    public static void main(String[] args) {
        String[] strs = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(points(strs));
    }

    public static int points(String[] strs) {
        // 1. 포맷
        Stack<Integer> stack = new Stack<>();

        // 2. 데이터를 뽑아낸다. with for
        for (String operation : strs) {
            switch (operation) {
                case "C": // 앞에 것 삭제
                    stack.pop();
                    break;
                case "D": // 앞에 것을 뽑아 2배로 만든 후 스택에 넣음
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y);
                    stack.push(x);
                    stack.push(x + y);
                    break;
                default:
                    stack.push(Integer.valueOf(operation));
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
