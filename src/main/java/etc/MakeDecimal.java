package etc;

public class MakeDecimal {

    /*
    (문제) 소수만들기 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/12977

    주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
    숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
    nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

    (예시)
    nums : [ 1, 2, 3, 4]
    result = 1

     */
    public static void main(String[] args) {
        MakeDecimal sol = new MakeDecimal();
        int[] nums = {1, 2, 3, 4,};
        System.out.println(sol.solution(nums));
    }

    public int solution(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isPrime(nums[i] + nums[j] + nums[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static boolean isPrime(int num) {
        boolean result = true;

        System.out.println("num :" + num);
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}
