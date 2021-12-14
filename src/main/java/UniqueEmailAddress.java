import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    /*
    1. 로컬 네임 + 도메인 네임
    2. 로컬네임에서 .은 무시한다
    3. 로컬네임에서 + 이후로 나오는 문자열은 무시한다
    4. 도메인 네임에서 .이 들어가면 고유하다

    [ 규칙 찾기 ]
    1. . => Continue로 뺀다
    2. + => break로 뺀다
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

