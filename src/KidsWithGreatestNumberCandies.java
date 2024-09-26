import java.util.ArrayList;
import java.util.List;

//time O(n)
//space O(n)
class KidsWithGreatestNumberCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            max = Math.max(max, candy);
        }

        for (int candy : candies) {
            // if (candy + extraCandies >= max) {
            //     result.add(true);
            // }
            // else result.add(false);
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}