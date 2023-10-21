//principle: the square of a value is always the sum of many consecutive odd integers
//1 = 1
//4 = 1 + 3
//9 = 1 + 3 + 5
//16 = 1 + 3 + 5 + 7
//25 = 1 + 3 + 5 + 7 + 9
// class ValidPerfectSquare {
//     public boolean isPerfectSquare(int num) {
//         int i = 1;
//         while (num > 0) {
//             num -= i;
//             i += 2;
//         }
//         return num == 0;
//     }
// }

//binary search
class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        //equal sign is for num = 1, to enter the while loop
        while (start <= end) {
            long mid = start + (end - start)/2;
            if (mid * mid == num) return true;
            else if (mid * mid < num) start = (int)mid + 1;
            else end = (int)mid - 1;
        }
        return false;
    }
}
