import java.util.HashMap;

public class Basic2 {

    /*
    (문제)
    https://app.codility.com/programmers/trainings/4/first_unique/

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
        Basic2 sol = new Basic2();
        int[] A = {1, 4, 3, 3, 1, 2};
        System.out.println(sol.solution(A));
    }

}
