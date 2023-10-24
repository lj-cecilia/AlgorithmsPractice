import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class findDuplicatesInArray {
     public List<Integer> findDuplicates(int[] nums) {
         HashSet<Integer> set = new HashSet<>();
         List<Integer> list = new ArrayList<>();

         for (int num : nums) {
             if (!set.add(num)) list.add(num);
         }

         return list;
     }
 }