class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        StringBuilder res = new StringBuilder();
        char[] str = s.toCharArray();
        int si = 0;
        int ei = str.length - 1;

        while (str[si++] == ' ') {}
        while (str[ei--] == ' ') {}

        for (int i = ei + 1; i >= si - 1; i--) {
            if (str[i] == ' ' && builder.length() > 0) {
                res.append(builder.reverse().append(str[i]));
                builder.delete(0, builder.length());
                while (str[--i] == ' ') {}
                builder.append(str[i]);
                continue;
            }
            builder.append(str[i]);
        }

        res.append(builder.reverse());
        return res.toString();
    }
}