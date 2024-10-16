//time O(n)
//space O(1)
class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int net = 0;
        int result = 0;
        for (int num : gain) {
            net += num;
            result = Math.max(result, net);
        }
        return result;
    }
}