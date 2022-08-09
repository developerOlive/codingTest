package codility_problem;

import java.util.Arrays;

public class UniqueArrayElement {

    /*
    (문제)
    you are given an array A consisting of N integers within the range [1..N].
    In one move, you can increase or decrease the value of any element by 1.
    After each move, all numbers should remain within the range [1..N].

    your task is to find the smallest required number of moves to make all elements in the array pairwise distinct
    (in other words, no value can appear in the array more than once).

    Give A = [1, 2, 1], the function should return 2.
    Because you can increase A[2] twice: [1,2,1] -> [1,2,2] -> [1,2,3].
    In this example, you could also change the array to the following values in two moves: [3,2,1],[1,3,2],[2,3,1].
     */

    public static void main(String[] args) {
        int[] A = {2,1,4,4};
        UniqueArrayElement sol = new UniqueArrayElement();
        System.out.println(sol.solution(A));
    }

    public int solution(int[] A) {

        Arrays.sort(A);

        int result = 0;
        int index = 1;
        int diff;

        for (int a : A) {
            diff = a - index;
            System.out.println("a : " + a + " / index : " + index + " / diff = " + diff);

            if (diff < 0) {
                result -= diff;
            } else if (diff > 0) {
                result += diff;
            }

            index += 1;
        }

        return result;
    }
}
