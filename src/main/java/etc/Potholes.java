package etc;

public class Potholes {

    /*
    (문제)
    you are given a description of a two-lane road in which two strings, L1 and L2,
    respectively represent the first and the second lane,
    each lane consisting of N segments of equal length.

    The K-th segment of the first lane is represented by L1[K]
    and the K-th segment of the second lane is represented by L2[K],
    where '.' denotes a smooth segment of road and 'x' denotes a segment containing potholes.

    Cars can drive over segments with potholes, but it is rather uncomfortable.
    Therefore, a project to repair as many potholes as possible was submitted.
    At most one contiguous stretch of each lane may be repaired at a time.
    For the time of reparation those stretches will be closed to traffic.

    How many road segments with potholes can be repaired given that the road must be kept open
    (in other words, stretches of roadworks must not prevent travel from one end of the road to the other)?

    that, given two strings L1 and L2 of length N,
    returns the maximum number of segments with potholes that can be repaired.

    1. Given L1 = "..xx.x." and L2 = "x.x.x..", your function should return 4.
    It is possible to repair three potholes in the first lane
    and the first pothole in the second lane without closing the road to traffic.
     */
    public static void main(String[] args) {
        String L1 = "..xx.x.";
        String L2 = "x.x.x..";
        Potholes sol = new Potholes();
        System.out.println(sol.solution(L1, L2));
    }

    public int solution(String L1, String L2) {

        long start = System.currentTimeMillis();

        char[] L1arr = L1.toCharArray();
        char[] L2arr = L2.toCharArray();

        int lane1X = 0;
        int lane2X = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < L1arr.length; i++) {
            if (L1arr[i] == 'x') {
                lane1X++;
            }
            if (L2arr[i] == 'x') {
                lane2X++;
            }
        }

        for (int i = 0; i < L1arr.length; i++) {
            if (L1arr[i] == 'x') {
                tmp1++;
            }
            if (L2arr[i] == 'x') {
                tmp2++;
            }

            int repairX = Math.min((tmp1 - tmp2 + lane2X), (tmp2 - tmp1 + lane1X))
                    + (L1arr[i] == 'x' ? 1 : 0)
                    + (L2arr[i] == 'x' ? 1 : 0);

            min = Math.min(lane1X, Math.min(lane2X, Math.min(min, repairX)));
        }

        int result = lane1X + lane2X - min;
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0);

        return result;
    }
}
