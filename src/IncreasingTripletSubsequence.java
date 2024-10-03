//time O(n)
//space O(1)
//with min1 being the smallest of all time
//min2 being the second smallest with index greater than min1
//if any value is greater than those two, it has greater value and index
class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min1) min1 = num;
            else if (num <= min2) min2 = num;
            else return true;
        }
        return false;
    }
}
