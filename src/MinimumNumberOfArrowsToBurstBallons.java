//time O(n)
//space O(1)

//three conditions
//1. [ ] [ ], increment count
//2. [ [ ] ], do not increment, update the end to the third value
//3. [ ], do not increment, the end stays the third value
//    [ ]
import java.util.Arrays;

class MinimumNumberOfArrowsToBurstBallons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        int end = points[0][1];
        int arrows = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= end) {
                end = Math.min(points[i][1], end);
            }
            else {
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}