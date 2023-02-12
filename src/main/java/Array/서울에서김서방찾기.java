package Array;

import java.util.Arrays;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/12919
    (문제)
    String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아,
    "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.
    seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 */
public class 서울에서김서방찾기 {
    public String findKim(String[] seoul) {
        //x에 김서방의 위치를 저장하세요.
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
    }

    // 실행을 위한 테스트코드입니다.
    public static void main(String[] args) {
        서울에서김서방찾기 kim = new 서울에서김서방찾기();
        String[] names = {"Queen", "Tod", "Kim"};
        System.out.println(kim.findKim(names));
    }
}
