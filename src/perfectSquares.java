//A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.

//Use dynamic programming to solve this problem
//iterate through 0 to n
//check initialize each value in array as the same of i
//denoting if there is no square appears in the sequence, then n = n # of 1 * 1;
class perfectSquares {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = i;
            for (int j = 1; j * j <= i; j++) {
                //retrieve all squares <= current index
                //if there is a square that = current index, the value becomes 1
                //or there could be other cases there the value is the sum of one square and many trivial 1's
                int square = j * j;
                memo[i] = Math.min(memo[i], memo[i - square] + 1);
            }
        }

        //at every position after the iteration, the value store at index will become the smallest number of sum of squares
        return memo[n];
    }
}