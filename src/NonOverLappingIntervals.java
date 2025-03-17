//time O(nlogn)
//space O(1)


import java.util.Arrays;

class NonOverLappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        int last = 0;
        //ascending order for the end point
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        //acount all the non overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[last][1]) {
                count++;
                last = i;
            }
        }
        //deduct the non-overlapping from total and the first interval to get all intervals need to be removed
        return intervals.length - count - 1;
    }
}