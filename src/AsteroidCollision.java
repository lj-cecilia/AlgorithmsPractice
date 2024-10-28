//time O(n) an asteroid will be visited twice at most, first round adding all, second round removing all, so max time is O(2n) = O(n)
//space O(n)

import java.util.Stack;

class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int asteroid : asteroids) {
            boolean add = true;
            while (!s.isEmpty() && s.peek() > 0 && asteroid < 0) {
                //negative outweigh positive, continue to collide
                if (s.peek() < Math.abs(asteroid)) {
                    s.pop();
                    continue;
                }
                //explode
                else if (s.peek() == Math.abs(asteroid)) {
                    s.pop();
                }
                //positive outweigh negative, don't add this negative
                add = false;
                break;
            }
            //default add
            if (add) s.push(asteroid);
        }
        int[] result = new int[s.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = s.peek();
            s.pop();
        }
        return result;
    }
}