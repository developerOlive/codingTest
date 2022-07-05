package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AthletesWhoDidNotFinish {
    /*
    (문제)
    수많은 마라톤 선수들이 마라톤에 참여하였습니다.
    단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
    마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
    완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

    (제한사항)
    마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
    completion의 길이는 participant의 길이보다 1 작습니다.
    참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    참가자 중에는 동명이인이 있을 수 있습니다.

    (예시)
    participant : ["leo", "kiki", "eden"]
    completion : ["eden", "kiki"]
    return : "leo"

    participant : ["mislav", "stanko", "mislav", "ana"]
    completion : ["stanko", "ana", "mislav"]
    return : "mislav"

     */
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        AthletesWhoDidNotFinish sol = new AthletesWhoDidNotFinish();
        System.out.println(sol.solution_with_hash_1(participant, completion));
    }


    public String solution_with_hash_1(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) map.put(player, map.getOrDefault(player, 0) + 1);
        for (String player : completion) map.put(player, map.get(player) - 1);

        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }


    public String solution_with_hash_2(String[] participant, String[] completion) {

        String answer = "";

        // 1. Hash 만들기 - key에 선수의 이름을, value에 count를 갖는 HashMap을 만든다.
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            // getOrDefault ==> 맵에서 key가 player인 값을 가져오되, 없으면 0을 가져오라는 의미
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 2. Hash 빼기 - completion에 존재하는 선수들의 Hash를 뺀다.
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        // 3. 마지막 주자 리턴 - value가 남아있는 선수가 완주하지 못한 선수이기 때문에 리턴한다.
        // Iterator : 반복을 쉽게해주는 하나의 클래스
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        /* 혹은 아래와 같이 keySet()을 이용할 수도 있다.
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        */

        return answer;
    }

    
    public String solve_with_sorting(String[] participant, String[] completion) {

        // 1. sorting
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 2. loop
        int i = 0;
        for (; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                break;
            }
        }

        return participant[i];
    }
}
