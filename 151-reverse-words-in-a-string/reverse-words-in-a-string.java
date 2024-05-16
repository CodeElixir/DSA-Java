class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        StringBuilder res = new StringBuilder();
        char[] str = s.toCharArray();
        
        boolean flag = false;

        int si = 0;
        int ei = str.length - 1;

        while (str[si++] == ' ') {}
        while (str[ei--] == ' ') {}

        for (int i = ei + 1; i >= si - 1; i--) {
            // if (i == s.length() - 1) {
            //     while (str[i] == ' ') {
            //         i--;
            //     }
            // }
            if (str[i] == ' ' && !flag && builder.length() > 0) {
                flag = true;
                res.append(builder.reverse());
                res.append(str[i]);
                builder.delete(0, builder.length());
            }

            if (str[i] != ' ') {
                flag = false;
                builder.append(str[i]);
            }
        }

        res.append(builder.reverse());

        // if (res.charAt(res.length() - 1) == ' ') {
        //     res.deleteCharAt(res.length() - 1);
        // }
        return res.toString();
    }
}