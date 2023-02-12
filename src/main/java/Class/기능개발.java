package Class;

import java.util.ArrayList;
import java.util.Arrays;

public class 기능개발 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/42586

    프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

    또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
    이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

    먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
    각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
    각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
     */

    int progressesCount;
    int[] needDays;
    ArrayList<Integer> workCountStorage;

    public int[] solution(int[] progresses, int[] speeds) {

        // 초기화
        progressesCount = progresses.length;
        needDays = new int[progressesCount];
        workCountStorage = new ArrayList<>();


        // 필요한 작업일 계산
        this.calcNeedDays(progresses, speeds);
        this.viewAll(needDays, 0);

        // 동시에 진행된 프로세스 계산
        for (int step = 0; step < progressesCount; ) {
            int stepNeedDay = needDays[step];

            // 날짜 동시에 경과
            for (int remainStep = step; remainStep < progressesCount; remainStep++) {
                needDays[remainStep] -= stepNeedDay;
            }
            this.viewAll(needDays, step);

            // 완료한 작업까지의 갯수
            int workCount = 1;
            for (; step + workCount < progressesCount; workCount++) {
                if (needDays[step + workCount] > 0) {
                    break;
                }
            }
            System.out.println("workCount:" + workCount);

            // 완료한 작업 갯수 저장
            workCountStorage.add(workCount);

            // 작업 갯수만큼 step 증가
            step += workCount;
        }

        return 기능개발.convertIntegers(workCountStorage);
    }

    private void calcNeedDays(int[] progresses, int[] speeds) {
        for (int i = 0; i < progressesCount; i++) {
            double remainProgress = 100 - progresses[i];
            double fNeedDay = remainProgress / speeds[i];

            needDays[i] = (int) Math.ceil(fNeedDay);
        }
    }

    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int size = integers.size();
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    private void viewAll(int[] array, int startIdx) {
        System.out.print("viewAll:");

        int arrayCount = array.length;
        for (int i = startIdx; i < arrayCount; i++) {
            System.out.print(array[i] + ",");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        기능개발 sol = new 기능개발();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
    }
}
