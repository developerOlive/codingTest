package Hash;

import java.util.HashSet;

public class GymSuit {

    /*
    (문제) 체육복 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/42862

    점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다.
    다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
    학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
    예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다.
    체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

    전체 학생의 수 n,
    체육복을 도난당한 학생들의 번호가 담긴 배열 lost,
    여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때,
    체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.

    (제한사항)
    전체 학생의 수는 2명 이상 30명 이하입니다.
    체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
    여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
    여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.

    (예시)
    n : 5 (= 총 학생 수)
    lost : [ 2, 4 ] (=도난당한 학생)
    reserve : [ 1, 3, 5 ] (=여분을 가지고 있는 학생)
    return : 5 (=5명 모두 체육수업 들을 수 있음)

     */

    public static void main(String[] args) {
        GymSuit sol = new GymSuit();
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        System.out.println(sol.solve_with_set(5, lost, reserve));
    }

    public int solve_with_set(int n, int[] lost, int[] reserve) {
        // 1. set 생성 - reverse 배열과 lost 배열로부터 생성
        HashSet<Integer> reserveSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();

        for (int i : reserve)
            reserveSet.add(i);
        for (int i : lost)
            if (reserveSet.contains(i)) {
                reserveSet.remove(i); // 여분있는 학생이 도둑 맞았는지 확인 -> remove하면 여분이 있지도, 도둑맞지도 않은 경우
            } else { // 도둑을 맞은 경우
                lostSet.add(i);
            }

        // 2. 여분 하나씩 처리 - reserve에서 하나씩 꺼내서, lost set에 줄 수 있는 사람을 찾는다.
        for (int i : reserveSet)
            if (lostSet.contains(i - 1)) { // 나보다 앞에 있는 학생이 존재하는지 확인
                lostSet.remove(i - 1); // 존재하면 lostSet에서 뺌 (=빌려줌)
            } else if (lostSet.contains(i + 1)) {// 나보다 뒤에 있는 학생이 존재하는지 확인
                lostSet.remove(i + 1); // 존재하면 lostSet에서 뺌 (=빌려줌)
            }

        // 3. 체육복을 가진 학생 수 계산 - 전체 n에서 lost set의 인원을 빼서 체육복을 갖고 있는 사람의 수를 반환한다.
        return n - lostSet.size();
    }
}
