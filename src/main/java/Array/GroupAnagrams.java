package Array;

import java.util.*;

public class GroupAnagrams {

    /*
    (문제)
    String 배열이 주어집니다.
    주어진 String은 배열 안에서 다른 String과 아나그램 관계입니다.

    아나그램이란?
    문자의 단어를 재배열하여 새로운 문자를 형성하는 것입니다.

    즉, 같은 알파벳으로 구성된 단어끼리 묶어 출력하는 문제입니다.

    (예시)
    input : strings = [ "eat", "tea", "ate", "nat", "bat" ]
    output : [ ["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]

    [ 문 제 분 석 ]
    1. 키 값은 고유하게,
    for loop을 이용해서 한 개의 string을 뺀 후 toCharArray를 이용해서 sort 후 키로 이용

    2. Map을 이용해서 key, value로 넣는다.

     */

    public static void main(String[] args) {

        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solve_with_sorting(list));
//        System.out.println(solve_with_ascii(list));
    }

    public static List<List<String>> solve_with_sorting(String[] strings) {

        List<List<String>> result = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            char[] charArray = str.toCharArray(); // toCharArray() => 문자열을 char 배열로 변환해준다.
            Arrays.sort(charArray); // ['a', 'e', 't']

            String key = String.valueOf(charArray);
            System.out.println("key : " + key);

            if (map.containsKey(key)) { // containsKey => 맵에서 인자로 보낸 키가 있으면 true, 없으면 false
                // 맵에서 키를 꺼내서, 단어를 넣음
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static List<List<String>> solve_with_ascii(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strings) {
            int[] count = new int[26]; // a-z
            for (int k = 0; k < str.length(); k++) {
                count[str.charAt(k) - 'a']++;
            }
            String key = Arrays.toString(count);
            System.out.println("key : " + key);

            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
