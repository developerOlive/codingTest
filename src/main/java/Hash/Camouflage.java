package Hash;

import java.util.*;

public class Camouflage {

    /*
    (문제) 위장 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/42578

    스파이들은 매일 다른 옷을 조합하여 입어 자신을 위장합니다.
    예를 들어 스파이가 가진 옷이 아래와 같고
    오늘 스파이가 동그란 안경, 긴 코트, 파란색 티셔츠를 입었다면
    다음날은 청바지를 추가로 입거나 동그란 안경 대신 검정 선글라스를 착용하거나 해야 합니다.

    스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때 서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.

    (제한사항)
    clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
    스파이가 가진 의상의 수는 1개 이상 30개 이하입니다.
    같은 이름을 가진 의상은 존재하지 않습니다.
    clothes의 모든 원소는 문자열로 이루어져 있습니다.
    모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.
    스파이는 하루에 최소 한 개의 의상은 입습니다.

    [ 문 제 분 석 ]
    - 종류별로 경우의 수를 구해야 할 때는 해시를 사용하는게 좋다.
    왜? 각 종류별로 옷이 몇 가지가 존재하는지 셀 수 있고, 이를 가지고 총 조합의 수를 계산 가능

     */

    public static void main(String[] args) {
        Camouflage sol = new Camouflage();
        String[][] clothes = {{"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}};

        System.out.println(sol.solve_with_hash(clothes));
    }

    public int solve_with_hash(String[][] clothes) {
        // 1.  종류별로 분류 - 여러 옷을 종류 별로 분류한다.
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        System.out.println("귱굼 : "  + map.toString());

        // 2. 입지 않는 경우 추가 - 종류별로 하나씩 입지 않아도 되니, 입지 않아도 되는 경우를 추가한다.
        Iterator<Integer> it = map.values().iterator();
        int answer = 1; // 누적된 값을 계산하기 위해 1로 시작

        while (it.hasNext()) { // 하나씩 꺼내되, 없으면 while문을 빠져나옴
            answer *= it.next().intValue() + 1; // 입지 않는 경우를 추가(+1) 해서 누적해서 곱함
        }

        // 3. 전체조합 - 전체조합을 계산하고, 아무것도 입지 않는 경우(-1)를 빼준다.
        return answer - 1;
    }
}
