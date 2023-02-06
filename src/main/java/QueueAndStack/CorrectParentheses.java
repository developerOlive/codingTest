package QueueAndStack;

import java.util.ArrayDeque;

public class CorrectParentheses {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/12909

    괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다.
    예를 들어 "()()" 또는 "(())()" 는 올바른 괄호입니다.
    ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
    '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고,
    올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
     */

    public static void main(String[] args) {
        CorrectParentheses sol = new CorrectParentheses();
        String s = "()())";
        System.out.println(sol.solution1(s));
    }

    // 올바른 괄호가 아닌 판단 조건
    // 1. 닫히는 괄호가 들어왔는데 스택이 비어있다.
    // 2. 마지막에 스택에 데이터가 남아 있다.
    public boolean solution1(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();
        for (char c : a) {
            if (c == '(') { // 열리는 괄호면 -> 스택에 쌓음
                stack.push(c);
            } else { // 닫히는 괄호면
                if (stack.isEmpty() || stack.pop() == c) { // 처음부터 스택이 비어있는 경우 or 마지막 꺼낸 값이 ')'인 경우
                    return false;
                }
            }
        }

        return stack.isEmpty(); // 마지막에 데이터가 남아있지 않아야 올바른 괄호임
    }

    public boolean solution2(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        // O(N)
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i); // O(1)

            if (now == '(') {
                stack.addLast(now); // O(1)
            } else {
                if (stack.isEmpty()) { // O(1)
                    return false;
                } else {
                    stack.pollLast(); // O(1)
                }
            }
        }
        return stack.isEmpty(); // O(1)
    }
}
