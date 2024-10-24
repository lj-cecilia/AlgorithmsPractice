////time O(n) since the sorting is done with size 26 array it's O(1)
////space O(1) for the size 26 array
//
//import java.util.Arrays;
//
//class DetermineIfTwoStringsAreClose {
//     public boolean closeStrings(String word1, String word2) {
//         if (word1.length() != word2.length()) return false;
//         char[] arr1 = new char[26];
//         char[] arr2 = new char[26];
//         for (char ch : word1.toCharArray()) {
//             arr1[ch - 'a']++;
//         }
//         for (char ch : word2.toCharArray()) {
//             arr2[ch - 'a']++;
//         }
//         //check if the same letter
//         for (int i = 0; i < 26; i++) {
//             if (arr1[i] != 0 && arr2[i] == 0) return false;
//             if (arr1[i] == 0 && arr2[i] != 0) return false;
//         }
//         Arrays.sort(arr1);
//         Arrays.sort(arr2);
//
//         for (int i = 0; i < 26; i++) {
//             if (arr1[i] != arr2[i]) return false;
//         }
//         return true;
//     }
// }

//time O(n) since sort is done with size 26, only for loop counts
//space O(1) since map size is only 26

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }
        for (char ch : word2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) return false;
        List<Integer> map1Values = new ArrayList<>(map1.values());
        List<Integer> map2Values = new ArrayList<>(map2.values());
        Collections.sort(map1Values);
        Collections.sort(map2Values);
        return map1Values.equals(map2Values);
    }
}