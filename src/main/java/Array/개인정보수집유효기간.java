package Array;

import java.util.*;

public class 개인정보수집유효기간 {

    /*
    (문제)
    https://school.programmers.co.kr/learn/courses/30/lessons/150370

    [input]
    today : "2022.05.19"
    terms : ["A 6", "B 12", "C 3"]
    privacies : ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]

    [output]
    result : [1,3]
     */

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> termMap = new HashMap<>();

        int date = getDate(today);

        for (String s : terms) {
            String[] term = s.split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }

        for (int i=0; i<privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            if (getDate(privacy[0]) + (termMap.get(privacy[1]) * 28) <= date) {
                answer.add(i+1);
            }
        }

        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return (year * 12 * 28) + (month * 28) + day;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        개인정보수집유효기간 sol = new 개인정보수집유효기간();
        System.out.println(Arrays.toString(sol.solution(today, terms, privacies)));
    }
}
