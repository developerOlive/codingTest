package QueueAndStack;

import java.util.ArrayDeque;
import java.util.HashMap;

public class RotateParenthesis {

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/76502
    */

    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution1(s));
    }

    public static int solution1(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length();
        s += s;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (!stack.isEmpty()) {
                        stack.pop();
                        map.get(c);
                    }
                }
            }

            if (stack.isEmpty())
                answer++;
        }

        return answer;
    }
}
