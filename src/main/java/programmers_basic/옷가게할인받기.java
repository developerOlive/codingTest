package programmers_basic;

public class 옷가게할인받기 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/120818
    머쓱이네 옷가게는 10만 원 이상 사면 5%,
    30만 원 이상 사면 10%,
    50만 원 이상 사면 20%를 할인해줍니다.
    구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
     */

    public static void main(String[] args) {
        int price = 150_000;
        System.out.println(solution(price));
    }

    public static int solution(int price) {
        if (price >= 500000) return (int) (price * 0.8);
        if (price >= 300000) return (int) (price * 0.9);
        if (price >= 100000) return (int) (price * 0.95);

        return price;
    }
}
