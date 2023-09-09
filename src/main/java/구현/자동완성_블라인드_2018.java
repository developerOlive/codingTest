package 구현;

import java.util.Arrays;
import java.util.HashMap;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/17685

    포털 다음에서 검색어 자동완성 기능을 넣고 싶은 라이언은 한 번 입력된 문자열을 학습해서 다음 입력 때 활용하고 싶어 졌다.
    예를 들어, go 가 한 번 입력되었다면, 다음 사용자는 g 만 입력해도 go를 추천해주므로 o를 입력할 필요가 없어진다!
    단, 학습에 사용된 단어들 중 앞부분이 같은 경우에는 어쩔 수 없이 다른 문자가 나올 때까지 입력을 해야 한다.
    효과가 얼마나 좋을지 알고 싶은 라이언은 학습된 단어들을 찾을 때 몇 글자를 입력해야 하는지 궁금해졌다.

    예를 들어, 학습된 단어들이 아래와 같을 때
    go
    gone
    guild

    go를 찾을 때 go를 모두 입력해야 한다.
    gone을 찾을 때 gon 까지 입력해야 한다. (gon 이 입력되기 전까지는 go 인지 gone 인지 확신할 수 없다.)
    guild 를 찾을 때는 gu 까지만 입력하면 guild 가 완성된다.
    이 경우 총 입력해야 할 문자의 수는 7이다.

    라이언을 도와 위와 같이 문자열이 입력으로 주어지면 학습을 시킨 후,
    학습된 단어들을 순서대로 찾을 때 몇 개의 문자를 입력하면 되는지 계산하는 프로그램을 만들어보자.
 */
public class 자동완성_블라인드_2018 {

    public static void main(String[] args) {
        String[] words = {"go", "gone", "guild"};
        System.out.println(solution(words));
    }

    public static int solution(String[] words) {
        HashMap<Integer, String> map = new HashMap<>();
        int count = 0;
        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            map.put(i, words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            count += getFindCount(map, i);
        }

        return count;
    }

    // 주어진 단어들 중 현재 단어를 기준으로 몇 개의 문자를 입력해야 하는지 계산합니다.
    public static int getFindCount(HashMap<Integer, String> map, int idx) {
        // 현재 단어가 리스트의 첫 번째 단어라면, 이전 단어가 없으므로 바로 다음 단어와 비교하여 자동완성을 위해 몇 개의 문자를 입력해야 하는지 계산합니다.
        if (idx == 0) {
            return getCloseFind(map, idx, idx + 1);
        } else if (idx == map.size() - 1) {
            // 현재 단어가 리스트의 마지막 단어라면, 다음 단어가 없으므로 바로 이전 단어와 비교하여 자동완성을 위해 몇 개의 문자를 입력해야 하는지 계산합니다.
            return getCloseFind(map, idx, idx - 1);
        } else {
            // 이전 단어와 다음 단어를 비교하여 둘 중 어느 쪽이 더 자동완성에 유리한지 계산합니다.
            return Math.max(getCloseFind(map, idx, idx - 1), getCloseFind(map, idx, idx + 1));
        }
    }

    // 두 단어 간의 자동완성을 위해 몇 개의 문자를 입력해야 하는지 계산
    public static int getCloseFind(HashMap<Integer, String> map, int idx, int targetIdx) {
        String self = map.get(idx);
        String target = map.get(targetIdx);

        int count = 0;
        for (int i = 0; i < self.length(); i++) {
            if (self.charAt(i) == target.charAt(i)) {
                count++;
            } else {
                count++;
                break;
            }
            if (i == target.length() - 1) {
                count++;
                break;
            }
        }

        return count;
    }
}
