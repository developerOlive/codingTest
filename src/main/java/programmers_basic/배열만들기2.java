package programmers_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열만들기2 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/181921

    */

    public static void main(String[] args) {
        int l = 5;
        int r = 555;
        System.out.println(Arrays.toString(solution(l, r)));
    }

    public static int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();

        for (int i = l; i <= r; i++) {
            if (containsOnlyZerosAndFives(i)) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1};
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean containsOnlyZerosAndFives(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit != 0 && digit != 5) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }
}
