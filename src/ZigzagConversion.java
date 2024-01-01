//Dec 31, 2023
//time O(n) space O(n)
import java.util.ArrayList;
import java.util.List;
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        int i = 0;
        while (i < s.length()) {
            //vertically down
            for (int j = 0; j <numRows && i < s.length(); j++, i++) {
                list.get(j).add(s.charAt(i));
            }
            //diagonally up
            for (int j = numRows - 2; j > 0 && i < s.length(); j--, i++) {
                list.get(j).add(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> l : list) {
            for (char ch : l) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}