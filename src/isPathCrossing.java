//Dec 23, 2023
//time O(n) space O(n)
import java.util.HashSet;

class isPathCrossing {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        HashSet<String> set = new HashSet<>();
        set.add(x + " " + y);
        for (char ch : path.toCharArray()) {
            switch (ch) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            if (!set.add(x + " " + y)) return true;
            set.add(x + " " + y);
        }
        return false;
    }
}