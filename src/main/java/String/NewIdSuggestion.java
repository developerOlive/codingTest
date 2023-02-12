package String;

public class NewIdSuggestion {

    /*
    (문제) 신규 아이디 추천 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/72410

    카카오에 입사한 신입 개발자 네오는 "카카오계정개발팀"에 배치되어,
    카카오 서비스에 가입하는 유저들의 아이디를 생성하는 업무를 담당하게 되었습니다.
    "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때,
    입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.

    "네오"는 다음과 같이 7단계의 순차적인 처리 과정을 통해
    신규 유저가 입력한 아이디가 카카오 아이디 규칙에 맞는 지 검사하고
    규칙에 맞지 않은 경우 규칙에 맞는 새로운 아이디를 추천해 주려고 합니다.

    1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

     */

    public String solution(String new_id) {

        String result = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();

        return result;
    }

    private static class KAKAOID {

        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", ""); // ^이 의미하는 것 : not
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("\\.+", "."); // .이 1개 이상 있을 때 ==> \.+
            return this;
        }

        private KAKAOID noStartEndDot() {
            // |는 or을 의미, ^(캐럿)이 밖에 나와있으면 . 으로 시작한다는 의미
            // $는 .으로 끝난다는 의미
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() > 15) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", ""); // $는 .으로 끝난다는 의미
            return this;
        }

        private KAKAOID noLessThan2() {
            while (s.length() < 3) {
                s += s.charAt(s.length() - 1);
            }
            return this;
        }

        private String getResult() {
            return s;
        }
    }

    public static void main(String[] args) {
        NewIdSuggestion sol = new NewIdSuggestion();
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        System.out.println(sol.solution(new_id));
    }
}
