// class findSpecialIntegerOccur25PercentTimes {
//     public int findSpecialInteger(int[] arr) {
//         int l = arr.length / 4;
//         int prev = -1;
//         int count = 0;
//         for (int num : arr) {
//             if (num == prev) {
//                 count++;
//                 //do not put the return statement inside the if clause just in case there is only one value in the array and we do not get to iterate to the second element which leaves us no prev to compare with
//             }
//             else {
//                 prev = num;
//                 count = 1;
//             }
//             if (count > l) return num;
//         }
//         return -1;
//     }
// }

class findSpecialIntegerOccur25PercentTimes {
    public int findSpecialInteger(int[] arr) {
        int l = arr.length;
        int[] num = new int[5];
        int index1 = binarySearch(arr[l/4], arr);
        if (arr[index1] == arr[index1 + l/4]) return arr[index1];

        int index2 = binarySearch(arr[l/2], arr);
        if (arr[index2] == arr[index2 + l/4]) return arr[index2];

        // int index3 = binarySearch(arr[(l*3)/4], arr);
        // if (arr[index3] == arr[index3 + l/4]) return arr[index3];

        //if not first one or second one then it's the third one
        return arr[(l*3)/4];
    }

    public int binarySearch(int value, int[] arr) {
        int index = -1;
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int m = l + (h - l)/2;
            //find the leftmost occurrence of the value
            if (arr[m] >= value) {
                index = m;
                h = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return index;
    }
}