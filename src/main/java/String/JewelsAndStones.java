package String;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        /*
        문제) 보석과 돌이 주어집니다.
        보석을 이용해서 돌에 얼마나 많은 보석이 포함되어 있는지 알고 싶습니다.
        문자는 대소문자를 구분하므로 "a"와 "A"는 다른 유형의 스톤으로 간주됩니다.

        문제분석)
        1. 보석은 대소문자를 구분해서 갖고 있어야 한다.
        2. aA -> 2개
        3. 보석을 저장한다. -> set
        4. Stone을 for문 루프
        5. Set에 있는 값과 비교해서 count
         */

        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(solve(jewels, stones));
    }

    public static int solve(String jewels, String stones) {
        // 1. data structure
        Set<Character> set = new HashSet<>();

        // 2. for while
        char[] charArr = jewels.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            set.add(charArr[i]); // a, A
        }

        int count = 0;
        char[] stoneArr = stones.toCharArray();
        for (int i = 0; i < stoneArr.length; i++) {
            if (set.contains(stoneArr[i])) {
                count++;
            }
        }
        return count;
    }
}
