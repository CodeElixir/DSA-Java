class Solution {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        StringBuilder res = new StringBuilder();
        // char[] str = s.toCharArray();
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == s.length() - 1) {
                while (s.charAt(i) == ' ') {
                    i--;
                }
            }
            if (s.charAt(i) == ' ' && !flag && builder.length() > 0) {
                flag = true;
                res.append(builder.reverse());
                res.append(s.charAt(i));
                builder = new StringBuilder();
            }

            if (s.charAt(i) != ' ') {
                flag = false;
                builder.append(s.charAt(i));
            }
        }

        res.append(builder.reverse());

        if (res.charAt(res.length() - 1) == ' ') {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
}