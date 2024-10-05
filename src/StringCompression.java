//time O(n) one pass with two pointers, j continue move forward, i update char and count
//space O(1) using original chars arr
class StringCompression {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        int count = 0;
        char prev = chars[0];

        while (j < chars.length) {
            if (chars[j] == prev) {
                count++;
            }
            else {
                chars[i] = prev;
                i++;
                if (count > 1) {
                    String countS = String.valueOf(count);
                    for (char ch : countS.toCharArray()) {
                        chars[i] = ch;
                        i++;
                    }
                }
                prev = chars[j];
                count = 1;
            }
            j++;
        }

        chars[i] = prev;
        i++;
        if (count > 1) {
            String countS = String.valueOf(count);
            for (char ch : countS.toCharArray()) {
                chars[i] = ch;
                i++;
            }
        }
        return i;
    }
}