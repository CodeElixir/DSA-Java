class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < strs[0].length()) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (i == str.length() || str.charAt(i) != ch) {
                    return builder.toString();
                }
            }
            builder.append(ch);
            i++;
        }
        return builder.toString();
    }
}