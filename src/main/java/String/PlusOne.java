package String;

public class PlusOne {
    /*
    문제) 음이 아닌 정수를 나타내는 비어있지 않은 십진수 배열이 주어지면 정수 1을 증가시킴
    배열의 마지막 숫자에 +1을 진행
    숫자 0 자체를 제외하고 정수의 앞에 0이 포함되지 않음

    예시)
    input digits = [1,2,3]
    output = [1,2,4]

    input: [9,9,9]
    output: [1,0,0,0]

    input: [0,0,1]
    output: [0,0,2]

    1. 뒷자리부터 체크 digits[2] + 1
    2. 값이 10이 되면 carry = 1로 1을 맨 앞자리에 추가
     */
    public static void main(String[] args) {
        int[] digits = {9, 9, 9, 9};

        int[] result = solve(digits);
        for (int i : result) {
            System.out.println("val : " + i);
        }
    }

    public static int[] solve(int[] digits) {

        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            // 2, 1, 0
            digits[i]++; // 1,2,4 // 9,9,10
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1]; // 0,0,0,0
        result[0] = 1;
        return result;
    }
}
