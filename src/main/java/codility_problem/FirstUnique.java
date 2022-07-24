package codility_problem;

import java.util.HashMap;

public class FirstUnique {

    /*
    (문제)
    https://app.codility.com/programmers/trainings/4/first_unique/

    A non-empty array A consisting of N integers is given. The unique number is the number that occurs exactly once in array A.
    For example, the following array A:
      A[0] = 4
      A[1] = 10
      A[2] = 5
      A[3] = 4
      A[4] = 2
      A[5] = 10
    contains two unique numbers (5 and 2).

    You should find the first unique number in A.
    In other words, find the unique number with the lowest position in A.
    For above example, 5 is in second position (because A[2] = 5) and 2 is in fourth position (because A[4] = 2).
    So, the first unique number is 5.
     */

    public int solution(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        for (int a : A) {
            if (map.get(a) == 1) {
                return a;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUnique sol = new FirstUnique();
        int[] A = {1, 4, 3, 3, 1, 2};
        System.out.println(sol.solution(A));
    }
}
