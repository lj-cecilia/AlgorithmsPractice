import java.util.ArrayList;

class StockSpanner {
    ArrayList<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        int days = 1;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (price >= list.get(i)) days++;
            else break;
        }
        list.add(price);
        return days;
    }
}
