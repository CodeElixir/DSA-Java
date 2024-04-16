class Solution {
    public int myAtoi(String s) {
        long result = 0l;
        s = s.trim();
        boolean isNegative = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (i == 0 && (ch == '+' || ch == '-')) {
                isNegative = (ch == '-') ? true : false;
            } else {
                if (!Character.isDigit(ch)) {
                    break;
                }

                int digit = Character.digit(ch, 10);
                result = Math.abs((result * 10)) + digit;
                if (isNegative) {
                    result = -result;
                }

                if (result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                if (result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } 
            }
        }
        return (int)result;
    }
}