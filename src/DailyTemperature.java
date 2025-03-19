//time O(n)
//space O(n)

//monotonic decreasing stack storing the index instead of elements values


import java.util.Stack;

class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        //push the first element into stack always
        s.push(0);
        //start looping from second element
        for (int i = 1; i < temperatures.length; i++) {
            //if the value is greater than the one in the stack
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                //pop out the value and store the days(difference  between current day and the stored day index)
                result[s.peek()] = i - s.peek();
                s.pop();
            }
            //push current element no matter what
            s.push(i);
        }
        return result;
    }
}