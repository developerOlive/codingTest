package QueueAndStack;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class RotateParenthesis {

    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/76502
    */

    public static void main(String[] args) {
        String s = "}]()[{";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Map<Character, Character> map = createParenthesesMap();
        int n = s.length();
        s += s;

        int answer = 0;

        for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                // 현재 돌고 있는 괄호가 열린 괄호의 경우, 스택에 push 하여 저장
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else { // 현재 돌고 있는 괄호가 닫힌 괄호인 경우
                    // 이미 열린 괄호가 존재하고, 현재 괄호가 그에 해당하는 닫힌 괄호일 때는 pop 으로 제거
                    // peek 으로 스택의 가장 위에 있는 요소를 꺼냄
                    if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                        stack.pop();
                    } else { // 현재 처리중인 괄호가 닫힌 괄호인데, 스택의 가장 위에 있는 괄호와 쌍을 이루지 않는 경우
                        stack.push(c);
                    }
                }
            }

            // 스택이 비어있다 = 모든 열린 괄호가 닫힌 괄호와 쌍을 이루었다는 의미
            if (stack.isEmpty()) {
                answer++;
            }

        }

        return answer;
    }

    private static Map<Character, Character> createParenthesesMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        return map;
    }
}
