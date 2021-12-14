import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    /*

    문제) 모든 유효한 이메일은 @을 기준으로 로컬 네임과 도메인 네임으로 구성된다.
    또한 소문자 외에 하나 이상의 '.' 또는 '+'이 포함될 수 있다.
    로컬 이름에 더하기('+')를 추가하면, 첫번째 더하기 기호 뒤에 모든 항목이 무시된다.
    이메일 목록이 주어지면, 목록의 각 주소로 하나의 이메일을 보낸다. 실제로 받는 이메일의 주소는?

    [ 문제 분석 ]
    1. 로컬 네임 + 도메인 네임
    2. 로컬네임에서 .은 무시한다
    3. 로컬네임에서 + 이후로 나오는 문자열은 무시한다
    4. 도메인 네임에서 .이 들어가면 고유하다

    [ 규칙 찾기 ]
    1. 로컬 네임에서 . => Continue로 뺀다
    2. 로컬 네임에서 + => break로 뺀다
    3. Set<String>
     */
    public static void main(String[] args) {

        UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();

        String[] emails = {
                "test.email+james@coding.com",
                "test.e.mail+toto.jane@cod.ing.com",
                "testemail+tom@cod.ing.com",
                "a@coding.com"
        };

        System.out.println(uniqueEmailAddress.solve_1(emails));
        System.out.println(uniqueEmailAddress.solve_split(emails));
    }

    // 1. 베이직 풀이
    public int solve_1(String[] emails) {
        // 1. ds
        Set<String> set = new HashSet<>(); // 중복 제거용

        // 2. for while - charAt()
        for (String email : emails) {
            String localName = makeLocalName(email);
            String domainName = makeDomainName(email);

            set.add(localName + "@" + domainName);
        }
        return set.size();
    }

    private String makeLocalName(String email) {
        StringBuilder stringBuilder = new StringBuilder();

        // "test.email+james@coding.com"
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '.') {
                continue;
            }
            if (email.charAt(i) == '+' || email.charAt(i) == '@') {
                break;
            }
            stringBuilder.append(email.charAt(i));
        }
        return stringBuilder.toString();
    }

    private String makeDomainName(String email) {
        return email.substring(email.indexOf("@") + 1);
    }

    // 2.split 문제풀이
    public int solve_split(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String[] localName = parts[0].split("\\+");
            set.add(localName[0].replace(".", "") + "@" + parts[1]);
        }
        return set.size();
    }
}

