//time O(nlogn)
//space O(n)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//solve with sorting and two pointer
class maxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int total = 0;


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            //in case for one difficulty there are two different profit, get the max one
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i], 0), profit[i]));
        }

        Arrays.sort(difficulty);
        Arrays.sort(worker);

        int max = 0;
        int j = 0;
        for (int i = 0; i < worker.length; i++) {
            while (j < difficulty.length && worker[i] >= difficulty[j]) {
                max = Math.max(max, map.get(difficulty[j]));
                j++;
            }
            total += max;

        }
        return total;
    }
}

