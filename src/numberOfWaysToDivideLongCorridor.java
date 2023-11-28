class numberOfWaysToDivideLongCorridor {
    public int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        long count = 1;
        int seats = 0;
        int prev = -1;
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seats++;
                if (seats == 2) {
                    //get current index, the starting of a multiplicant
                    prev = i;
                    //clear up the seat
                    seats = 0;
                }
                //else if we meet a new one and we already find a pair(prev!=-1)
                else if (seats == 1 && prev != -1) {
                    count *= (i - prev);
                    count %= MOD;
                }
            }
        }
        if (seats == 1 || prev == -1) return 0;
        return (int) count;

    }
}