class FindJudgeFromEdges {

    //goal - find judge
    //judge can trust no one, everyone trusts judge
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        for (int i = 0; i < trust.length; i++) {
            int truster = trust[i][0];
            int trustee = trust[i][1];
            //deduct count if one trusts others
            count[truster]--;
            //increment the count for whom is trusted
            count[trustee]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (count[i] == n - 1) return i;
        }
        return -1;
    }
}