
/*
trim to get rid of the leading and ending white spaces
check if we have the + or - sign with the boolean
read in the following chars until non digit is encountered
get rid of the leading 0's as well
clamp our result depending on whether we exceeds the max and min range of integers
*/
class StringToInteger {
    public int myAtoi(String s) {
        boolean isNegative = false;
        int index = 0;
        int l = s.length();
        int result = 0;

        while (index < l && s.charAt(index) == ' ') index++;
        if (index < l && s.charAt(index) == '+') {
            index++;
            isNegative = false;
        }
        else if (index < l && s.charAt(index) == '-') {
            index++;
            isNegative = true;
        }

        while (index < l && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return isNegative? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result *= 10;
            result += digit;
            index++;
        }
        System.out.println(result);

        return isNegative? -result : result;
    }
}
