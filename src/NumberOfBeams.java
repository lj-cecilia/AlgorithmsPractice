class NumberOfBeams {
    public int numberOfBeams(String[] bank) {
        int total = 0;
        int prev = 0;
        for (int i = 0; i < bank.length; i++) {
            int count = 0;
            for (char ch : bank[i].toCharArray()) {
                if (ch == '1') count++;
            }
            if (count != 0) {
                total += prev * count;
                prev = count;
            }
        }
        return total;
    }
}