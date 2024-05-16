class Solution {
    public String largestOddNumber(String num) {
        StringBuilder str = new StringBuilder(num);
        while (str.length() > 0 && (str.charAt(str.length() - 1) - '0') % 2 == 0) {
            str.deleteCharAt(str.length() - 1);
        }
        return str.toString();
    }
}