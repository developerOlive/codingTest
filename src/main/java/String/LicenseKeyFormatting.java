package String;

import java.util.Locale;
import java.util.StringJoiner;

public class LicenseKeyFormatting {
    /*
    설명) 숫자, 문자, 대시로만 구성된 문자열로 표시된 라이센스 키가 제공됨
    문자열은 대시로 n과 n+1 그룹으로 구분됨
    정수값 k도 주어짐
    첫번째 그룹을 제외하고 각 그룹이 정확히 k로 자열을 형식화 해야 함
    첫번째 그룹은 더 짧을수 있지만, 여전히 적어도 하나의 문자를 포함해야 함
    또한 두 그룹 사이에 대시가 삽입되어야하며, 모든 소문자를 대문자로 변환해야 함
    재포맷된 라이센스 키를 리턴하기

    예시) s = "8F3Z-2e-9-w", k = 4
    output = "8F3Z-2E9W"

    규칙)
    1. - 를 없애기기 / replace
    2. 대문자로 만들기 / toUpperCase()
    3. k=4로 문자열 나누기
    4. 나눈 문자열 사이 - 대시 넣기
     */
    public static void main(String[] args) {
//        String str = "8F3Z-2e-9-wabcdef";
        String str = "8F3Z-2e-9-w";
        int k = 4;
        System.out.println(solve(str, k));
    }

    public static String solve(String str, int k) {
        // 1. - 지우기
        String newStr = str.replace("-", "");

        // 2. upper
        newStr = newStr.toUpperCase();

        // 3. k개로 파싱하기, 그리고 - 넣기
        StringBuilder sb = new StringBuilder(newStr);
        int length = sb.length();
        for (int i = k; i < length; i = i + k) {
            sb.insert(length - i, '-');
        }
        return sb.toString();
    }
}
