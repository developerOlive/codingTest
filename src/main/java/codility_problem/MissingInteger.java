package codility_problem;

import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    /*
    (문제)

    https://app.codility.com/c/run/demoBVPHYC-NYV/

    that, given an array A of N integers,
    returns the smallest positive integer (greater than 0) that does not occur in A.

    For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
    Given A = [1, 2, 3], the function should return 4.
    Given A = [−1, −3], the function should return 1.
     */

    public int solution(int[] A) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        MissingInteger sol = new MissingInteger();
        int A[] = {-1, -3};

        System.out.println(sol.solution(A));
    }
}
