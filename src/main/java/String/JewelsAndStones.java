package String;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        /*
        문제) 보석과 돌이 주어집니다.
        보석을 이용해서 돌에 얼마나 많은 보석이 포함되어 있는지 알고 싶습니다.
        문자는 대소문자를 구분하므로 "a"와 "A"는 다른 유형의 스톤으로 간주됩니다.
         */

        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(solve(jewels, stones));
    }

    public static int solve(String jewels, String stones) {
        
        Set<Character> set = new HashSet<>();

        char[] charArr = jewels.toCharArray();
        for (char c : charArr) {
            set.add(c);
        }

        char[] stoneArr = stones.toCharArray();

        return (int) IntStream.range(0, stones.length()).filter(i -> set.contains(stoneArr[i])).count();
    }
}
