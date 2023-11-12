class CountPosAndNegIntegers {
    public int maximumCount(int[] nums) {
        int nonpos = binarySearch(nums, 1);
        int pos = nums.length - nonpos;
        int neg = binarySearch(nums, 0);

        return Math.max(pos,neg);
    }

    public int binarySearch(int[] nums, int goal) {
        int l = 0;
        int h = nums.length;
        while (l < h) {
            int m = l + (h - l)/2;
            //already check middle value, we know it's smaller than target
            //it could not be the insertion point, because insertion point should at least be greater than the lower bound
            if (nums[m] < goal) l = m + 1;
                //our while loop condition is exclusive for the case l = h, so our high should remain middle so we can examine values from l to m - 1
            else h = m;
        }
        return l;
    }
}
