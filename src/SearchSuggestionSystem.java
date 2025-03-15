//time O(m * nlogn), n is product size, m is search word size
//space O(n)
import java.util.*;

class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> q = new PriorityQueue<>(Collections.reverseOrder());
        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= searchWord.length(); i++) {
            String substring = searchWord.substring(0, i);

            for (String product : products) {
                if (product.startsWith(substring)) {
                    q.offer(product);
                }
                if (q.size() > 3) q.poll();
            }
            LinkedList<String> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                temp.addFirst(q.poll());
            }
            result.add(temp);
        }
        return result;
    }
}