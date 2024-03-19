//time O(n)
//space O(n)
import java.util.ArrayList;
import java.util.List;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> l = new ArrayList<>();
        int i = 0;

        //get all the arr that's smaller than the inteval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            l.add(intervals[i]);
            i++;
        }

        //merge the arrs that overlaps with the interval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        l.add(newInterval);

        //get the arr that's larger than the interval
        while (i < intervals.length && intervals[i][0] > newInterval[1]) {
            // while (i < intervals.length) { //equivalent to above
            l.add(intervals[i]);
            i++;
        }

        return l.toArray(new int[l.size()][2]);
    }
}


//time O(n)
//space O(n)
//class Solution {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> list = new ArrayList<>();
//        int start = newInterval[0];
//        int end = newInterval[1];
//
//        for (int[] interval : intervals) {
//            int curStart = interval[0];
//            int curEnd = interval[1];
//
//            //completely smaller than interval
//            if (curEnd < start) list.add(new int[] {curStart, curEnd});
//
//                //completely larger than interval, add interval and replace the start and end
//            else if (curStart > end) {
//                list.add(new int[] {start, end});
//                start = curStart;
//                end = curEnd;
//            }
//
//            //lie in between, update the start and end
//            else {
//                start = Math.min(start, curStart);
//                end = Math.max(end, curEnd);
//            }
//        }
//
//        list.add(new int[] {start, end});
//
//        return list.toArray(new int[list.size()][2]);
//    }
//}