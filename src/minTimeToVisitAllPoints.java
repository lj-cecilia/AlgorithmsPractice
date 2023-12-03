class minTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int total = 0;
        for (int i = 1; i < points.length; i++) {
            int[] prev = points[i - 1];
            int[] curr = points[i];
            total += Math.max(Math.abs(prev[0] - curr[0]), Math.abs(prev[1] - curr[1]));
        }

        return total;
    }
}