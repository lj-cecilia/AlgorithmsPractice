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

        return l.toArray(new int[l.size()][]);
    }
}