package Class;

public class KeypadPress {

    /*
    (문제) 키패드 누르기 - 프로그래머스
    https://school.programmers.co.kr/learn/courses/30/lessons/67256

    전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
    맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.

    1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
    2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
    3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
    4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
        4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
        순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
        각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.

     */

    Position left;
    Position right;
    Position numberPosition;

    public String solution_with_class(int[] numbers, String hand) {

        String answer = "";

        // 1. 왼손, 오른손 위치 초기화
        left = new Position(3, 0);
        right = new Position(3, 2);

        for (int num : numbers) {
            // 2. 숫자를 누를 손가락 정하기
            numberPosition = new Position((num - 1) / 3, (num - 1) % 3);
            if (num == 0) {
                numberPosition = new Position(3, 1);
            }

            String finger = numberPosition.getFinger(hand);

            // 3. 정해진 손가락을 answer에 담고, 손가락 위치 이동
            answer += finger;

            if (finger.equals("L")) {
                left = numberPosition;
            } else {
                right = numberPosition;
            }
        }

        return answer;
    }

    class Position {
        int row;
        int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand) {
            String finger = hand.equals("right") ? "R" : "L";

            if (this.col == 0) {
                finger = "L";
            } else if (this.col == 2) {
                finger = "R";
            } else {
                int leftDistance = left.getDistance(this);
                int rightDistance = right.getDistance(this);

                if (leftDistance < rightDistance) {
                    finger = "L";
                } else if (rightDistance < leftDistance) {
                    finger = "R";
                }
            }

            return finger;
        }

        public int getDistance(Position p) {
            return Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
        }

        // =====================================================================

        int[][] keypadPosition = {
                {3, 1}, //0
                {0, 0}, //1
                {0, 1}, //2
                {0, 2}, //3
                {1, 0}, //4
                {1, 1}, //5
                {1, 2}, //6
                {2, 0}, //7
                {2, 1}, //8
                {2, 2}  //9
        };

        // 초기위치
        int[] leftPosition = {3, 0};
        int[] rightPosition = {3, 2};

        String hand;

        public String solution(int[] numbers, String hand) {
            this.hand = (hand.equals("right")) ? "R" : "L";

            String answer = "";
            for (int num : numbers) {
                String Umji = pushNumber(num);
                answer += Umji;

                if (Umji.equals("L")) {
                    leftPosition = keypadPosition[num];
                    continue;
                }
                if (Umji.equals("R")) {
                    rightPosition = keypadPosition[num];
                    continue;
                }
            }

            return answer;
        }

        // 버튼을 누를 때 사용하는 손
        private String pushNumber(int num) {
            if (num == 1 || num == 4 || num == 7) return "L";
            if (num == 3 || num == 6 || num == 9) return "R";
            if (getDist(leftPosition, num) > getDist(rightPosition, num)) return "R";
            if (getDist(leftPosition, num) < getDist(rightPosition, num)) return "L";


            return this.hand;
        }

        private int getDist(int[] pos, int num) {
            return Math.abs(pos[0] - keypadPosition[num][0]) + Math.abs(pos[1] - keypadPosition[num][1]);
        }

    }


    public static void main(String[] args) {
        KeypadPress sol = new KeypadPress();
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        System.out.println(sol.solution_with_class(numbers, hand));
    }
}

