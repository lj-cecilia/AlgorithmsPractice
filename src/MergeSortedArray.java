//time O(m + n)
//space O(1) no extra space
class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // last element in nums1's initialized part
        int j = n - 1; // last element in nums2
        int k = nums1.length - 1; // last position in nums1

        while (i >= 0 && j >= 0) {
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 > num2) {
                nums1[k--] = num1;
                i--;
            } else {
                nums1[k--] = num2;
                j--;
            }
        }

        // Only need to copy remaining nums2 elements if any
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
