//time O(n)
//space O(n)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class FindDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        // for (int num : nums2) {
        //     if (!set1.contains(num) && !result.get(1).contains(num)) {
        //         result.get(1).add(num);
        //     }
        // }
        // for (int num : nums1) {
        //     if (!set2.contains(num) && !result.get(0).contains(num)) {
        //         result.get(0).add(num);
        //     }
        // }

        //improve
        for (int num : set2) {
            if (!set1.contains(num)) {
                result.get(1).add(num);
            }
        }
        for (int num : set1) {
            if (!set2.contains(num)) {
                result.get(0).add(num);
            }
        }
        return result;
    }
}