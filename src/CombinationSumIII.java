//time O(9^k)
//space O(k)


import java.util.ArrayList;
import java.util.List;

class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, 1, k, n, new ArrayList<>());
        return result;
    }

    public void backtrack(List<List<Integer>> result, int start, int k, int n, List<Integer> current) {
        if (current.size() == k && n == 0) {
            result.add(new ArrayList<>(current));
        }
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(result, i + 1, k, n - i, current);
            current.remove(current.size() - 1);
        }
    }
}