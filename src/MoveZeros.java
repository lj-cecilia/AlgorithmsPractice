//time O(n)
//space O(1)
//two pointers
class MoveZeros {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        while (i < nums.length) {
            nums[i] = 0;
            i++;
        }
    }
}