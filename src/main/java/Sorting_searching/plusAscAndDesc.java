package Sorting_searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class plusAscAndDesc {

    /*
    (문제)
    임의의 자연수 N이 주어질 때, 각 자리의 숫자를 정렬하려고 합니다.
    예를 들어 주어진 숫자 N = 2613인 경우, 각 자릿수를 오름차순으로 정렬하면 1236이 되며
    내림차순으로 정렬하면 6321이 되고, 두 숫자의 합은 7557이 됩니다.
    임의의 자연수 N이 매개변수로 주어질 때 N의 각 자릿수를 오름차순으로 정렬한 수와
    내림차순으로 정렬한 수의 합을 return 하도록 solution의 함수를 완성해 주세요.
     */

    public static void main(String[] args) {
        plusAscAndDesc sol = new plusAscAndDesc();
        System.out.println(sol.solution(2631));
    }

    public int solution(int N) {

        int[] nIntArr = Stream.of(String.valueOf(N).split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nIntArr);

        StringBuilder ascBuilder = new StringBuilder();
        for (int i : nIntArr) {
            ascBuilder.append(i);
        }
        int finalAsc = Integer.parseInt(ascBuilder.toString());


        Integer[] nIntegerArr = Arrays.stream(nIntArr).boxed().toArray(Integer[]::new);
        Arrays.sort(nIntegerArr, Collections.reverseOrder());

        StringBuilder descBuilder = new StringBuilder();
        for (int i : nIntegerArr) {
            descBuilder.append(i);
        }
        int finalDesc = Integer.parseInt(descBuilder.toString());

        return finalAsc + finalDesc;
    }
}
