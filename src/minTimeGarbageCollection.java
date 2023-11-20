class minTimeGarbageCollection {
    public int garbageCollection(String[] garbage, int[] travel) {
        //lower case for distance, upper case for garbage
        int m = 0, M = 0;
        int p = 0, P = 0;
        int g = 0, G = 0;
        int distance = 0;
        for (int i = 0; i < garbage.length; i++) {
            if (i > 0) distance += travel[i - 1];
            String s = garbage[i];
            for (char ch : s.toCharArray()) {
                switch(ch) {
                    case 'M':
                        M++;
                        m = distance;
                        break;
                    case 'P':
                        P++;
                        p = distance;
                        break;
                    case 'G':
                        G++;
                        g = distance;
                        break;
                }
            }
        }

        return m + M + p + P + g + G;
    }
}