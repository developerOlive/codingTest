package String;

public class Powers {

    /*
    (문제)
    3의 거듭 제곱수는 3을 b번 곱한 수를 의미하며, 3^b의 형태로 표현합니다.
    3^0 = 1 이성립하며, 3^1 = 3, 3^2 = 9, 3^3 = 27, 3^4 = 81 모두 거듭제곱수 입니다.
    3의 거듭 제곱수를 임의로 더하여 거듭 제곱수 사이에 들어가는 수를 만들 수 있습니다.
    예를들어,
    4 = 1 + 3
    31 = 27 + 3 + 1

    입니다.
    이 때, 같은 거듭 제곱수를 2번 이상 더할 수는 없습니다.
    이러한 규칙으로 만들어낼 수 있는 수와 3의 거듭 제곱수를 합쳐서 순번대로 배치하면
    1,3,4,9,10.. 이 됩니다.
    이렇게 배치한 숫자의 n번째 숫자가 무엇인지를 알려주는 함수를 완성해주세요.

    (예시)
    n = 4 / result = 9
    n = 11 / result = 31
     */

    public static void main(String[] args) {
        Powers sol = new Powers();
        System.out.println(sol.solution(4));
    }

    public long solution(long n) {
        long answer = 0L;
        StringBuilder binary = new StringBuilder();

        while (n > 1) {
            binary.append(n % 2);
            n = n / 2;
        }

        binary.append(n);

        for (int i = 0; i < binary.length(); i++) {
            long temp = 1;
            if (binary.charAt(i) == '1') {
                for (int j = 0; j < i; j++) {
                    temp *= 3;
                }
                answer += temp;
            }
        }

        return answer;
    }
}
