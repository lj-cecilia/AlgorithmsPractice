class XORDoesValidArrayExist {
    public boolean doesValidArrayExist(int[] derived) {
        //Assume we have an original array, it constitutes the derived array
        //D[i] = A[i] XOR A[i + 1]
        //XOR(derived) = A[0] XOR A[1] XOR A[1] XOR A[2]... XOR A[n - 2]
        //XOR A[n - 1] XOR A[n - 1] XOR A[0]
        //all cancels out from the intermediary values and A[0] cancel out from the beginning element and the last element
        //overall the XOR(derived) is 0

        //for there to exist an original array, the XOR(derived) should be 0

        int result = 0;
        for (int num : derived) {
            result ^= num;
        }
        return result == 0;
    }
}