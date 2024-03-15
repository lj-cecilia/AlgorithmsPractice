//time O(n)
//space O(1)
class pivotInteger {
    public int pivotInteger(int n) {
        int start = 0;
        int end = n;
        int sum1 = 0;
        int sum2 = 0;
        while (start <= end) {
            if (sum1 > sum2) {
                sum2 += end;
                end--;
            }
            else if (sum1 <= sum2) {
                sum1 += start;
                start++;
            }
            if (sum1 == sum2 && start == end) {
                return start;
            }
        }
        return -1;
    }
}

//time O(logn)
//space O(1)
//class pivotInteger {
//    public int pivotInteger(int n) {
//        int start = 1;
//        int end = n;
//        while (start < end) {
//            int mid = start + (end - start)/2;
//            if (mid * mid < (n * (n + 1))/2) {
//                start = mid + 1;
//            }
//            else {
//                end = mid;
//            }
//        }
//        return end * end - (n * (n + 1))/2 == 0? end : -1;
//    }
//}