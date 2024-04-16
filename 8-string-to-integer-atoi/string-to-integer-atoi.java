class Solution {
    public int myAtoi(String s) {
        // long result = 0l;
        // s = s.trim();
        // boolean isNegative = false;
        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if (i == 0 && (ch == '+' || ch == '-')) {
        //         isNegative = (ch == '-') ? true : false;
        //     } else {
        //         if (!Character.isDigit(ch)) {
        //             break;
        //         }

        //         int digit = Character.digit(ch, 10);
        //         result = Math.abs((result * 10)) + digit;
        //         if (isNegative) {
        //             result = -result;
        //         }

        //         if (result < Integer.MIN_VALUE) {
        //             return Integer.MIN_VALUE;
        //         }

        //         if (result > Integer.MAX_VALUE) {
        //             return Integer.MAX_VALUE;
        //         } 
        //     }
        // }
        // return (int)result;

        int sign = 1;
        int res = 0;
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check for sign.
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }

        // Check for a digit.
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                // Check overflow
                if (res > Integer.MAX_VALUE / 10 || 
                (res == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = (res * 10) + (s.charAt(i++) - '0');
        }
        return res * sign;
    }
}