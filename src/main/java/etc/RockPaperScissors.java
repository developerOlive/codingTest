package etc;

public class RockPaperScissors {

    /*
    (문제)
    Franco is going to play a game of Rock-Paper-Scissors with his Giovanni.
    In each turn, both players make their chosen gesture (rock, paper or scissors) simultaneously.
    After ever turn, players gain points as follows:
    2 for a win (rock beats scissors, scissors beat paper and paper beats rock),
    1 for a tie (when both players show the same gesture) and 0 for a loss.

    Franco watns to surprise Giovanni by using a very simple startegy:
    he will make the same gesture in every turn throughout the game.
    what is the maximum number of points he can score using this strategy?

    that, given a string G representing the sequence of Giovanni's turns ('R' represents a rock, 'P' represents paper and 'S' represents scissors),
    returns the maximum number of points Franco can score using his strategy.
     */

    public static void main(String[] args) {
        String G = "PRPRRPP";
        RockPaperScissors sol = new RockPaperScissors();
        System.out.println(sol.solution(G));
    }

    public int solution(String G) {

        char[] chars = G.toCharArray();
        char[] rps = {'R', 'P', 'S'};

        int rockWin = 0;
        int paperWin = 0;
        int scissorsWin = 0;

        for (char i : rps) {
            switch (i) {
                case 'R':
                    for (int j = 0; j < chars.length; j++) {
                        if (chars[j] == 'R') {
                            rockWin += 1;
                        }
                        if (chars[j] == 'S') {
                            rockWin += 2;
                        }
                    }

                case 'P':
                    for (int j = 0; j < chars.length; j++) {
                        if (chars[j] == 'P') {
                            paperWin += 1;
                        } else if (chars[j] == 'R') {
                            paperWin += 2;
                        }
                    }

                case 'S':
                    for (int j = 0; j < chars.length; j++) {
                        if (chars[j] == 'S') {
                            scissorsWin += 1;
                        } else if (chars[j] == 'P') {
                            scissorsWin += 2;
                        }
                    }
            }

            return Math.max(rockWin, Math.max(paperWin, scissorsWin));
        }

        return Math.max(rockWin, Math.max(paperWin, scissorsWin));
    }
}
