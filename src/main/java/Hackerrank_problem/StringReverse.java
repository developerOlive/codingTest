package Hackerrank_problem;

public class StringReverse {

    /*
    (문제)
    https://www.hackerrank.com/challenges/java-string-reverse/problem

    A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward. Given a string A, print Yes if it is a palindrome, print No otherwise.

    Constraints
    A will consist at most 50 lower case english letters.

    Sample Input
    madam

    Sample Output
    Yes
     */
    public String solution(String str) {
        for (int i=0; i<str.length()/2; i++) {
            if (str.charAt(i) == str.charAt(str.length() -i - 1)) {
                continue;
            } else {
                return "No";
            }
        }

        return "Yes";
    }

    public static void main(String[] args) {
        StringReverse sol = new StringReverse();
        System.out.println(sol.solution("madam"));
    }
}
