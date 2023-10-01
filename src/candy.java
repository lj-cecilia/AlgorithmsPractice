class candy {
    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] result = new int[length];
        result[0] = 1;
        //take care of the left neighbors smaller than current
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
            else result[i] = 1;
        }

        //take care of the right neighbors smaller than current
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i], result[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int num : result) sum += num;
        return sum;
    }
}