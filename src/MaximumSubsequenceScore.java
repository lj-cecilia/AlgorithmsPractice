//time O(nlogn)
//space O(n)

import java.util.Arrays;
import java.util.PriorityQueue;

//time is nlogn for array sorting
//logk for insert or remove from priorityQueue, nlogk for the second for loop, but overall nlogn
//space is n for storing array, k for minHeap, k < n, so overall n
//nums1 is to accumulate, nums2 is to sort descending
class MaximumSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int l = nums1.length;
        int[][] arr = new int[l][2];
        for (int i = 0; i < l; i++) {
            arr[i][0] = nums1[i];
            arr[i][1] = nums2[i];
        }
        //sort the array based on nums2 element descendingly
        Arrays.sort(arr, (a, b) -> b[1]- a[1]);
        //ascending list of nums1, so that we can get rid of the smallest element every time
        PriorityQueue<Integer> q = new PriorityQueue<>();
        long result = 0;
        long sum = 0;
        for (int[] a : arr) {
            sum += a[0];
            q.add(a[0]);
            if (q.size() > k) sum -= q.poll();
            if (q.size() == k) result = Math.max(result, (sum * a[1]));
        }
        return result;
    }
}