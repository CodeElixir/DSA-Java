class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch1 = s.charAt(i);
            char ch2 = (i == s.length() - 1) ? '0' : s.charAt(i + 1);
            int num1 = getNumber(ch1);
            int num2 = getNumber(ch2);
            // System.out.println(num1 + ", " + num2);
            if (num1 >= num2) {
                res = num1 + res;
            } else {
                res = res - num1;
            }
            // System.out.println(res);
        }
        
        return res;
    }

    private int getNumber(char ch) {
        switch(ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}