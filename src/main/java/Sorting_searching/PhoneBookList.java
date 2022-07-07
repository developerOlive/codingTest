package Sorting_searching;

import java.util.Arrays;
import java.util.HashMap;

public class PhoneBookList {
    /*
    (문제) 전화번호 목록

    전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
    전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

    구조대 : 119
    박준영 : 97 674 223
    지영석 : 11 9552 4421

    전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
    어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

    (제한사항)
    phone_book의 길이는 1 이상 1,000,000 이하입니다.
    각 전화번호의 길이는 1 이상 20 이하입니다.
    같은 전화번호가 중복해서 들어있지 않습니다.

    (예시)
    - phone_book : ["119", "97674223", "1195524421"]
    - return : false

     */

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        PhoneBookList sol = new PhoneBookList();
        System.out.println(sol.solution_with_hash(phone_book));
    }

    public boolean solution_with_sorting(String[] phone_book) {
        // 1. phone_book 정렬
        Arrays.sort(phone_book);

        // 2. 정렬 중 loop을 돌면서 앞번호가 뒷번호의 접두어인지 확인
        for (int i=0; i<phone_book.length-1; i++)
            if (phone_book[i+1].startsWith(phone_book[i]))
                return false;

        return true;
    }

    public boolean solution_with_hash(String[] phone_book) {
        // 1. hashMap을 만들고, 모든 전화번호를 hashMap에 넣는다.
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<phone_book.length; i++) {
            map.put(phone_book[i], 1); // key를 가지고 존재유무를 판단하기 때문에 value는 큰 의미가 없다.
        }

        // 2. 모든 전화번호의 접두어가 맵에 들어있는지 확인한다.
        for (int i=0; i<phone_book.length; i++) {
            for (int j=1; j<phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0,j))) {

                    return false;
                }
            }
        }

        return true;
    }
}
