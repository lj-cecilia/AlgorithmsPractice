class minimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        while (index1 < l1 && index2 < l2) {
            if (nums1[index1] == nums2[index2]) return nums1[index1];
            else if (nums1[index1] < nums2[index2]) index1++;
            else index2++;
        }
        return -1;
    }
}