class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Naive
        // StringBuilder builder = new StringBuilder();
        // int i = 0;
        // while (i < strs[0].length()) {
        //     char ch = strs[0].charAt(i);
        //     for (String str : strs) {
        //         if (i == str.length() || str.charAt(i) != ch) {
        //             return builder.toString();
        //         }
        //     }
        //     builder.append(ch);
        //     i++;
        // }
        // return builder.toString();
        
        StringBuilder builder = new StringBuilder();
        Arrays.sort(strs);
        char[] s1 = strs[0].toCharArray();
        char[] s2 = strs[strs.length - 1].toCharArray();
        int n = Math.min(s1.length, s2.length);
        for (int i = 0; i < n; i++) {
            if (s1[i] == s2[i]) {
                builder.append(s1[i]);
            } else {
                return builder.toString();
            }
        }
        return builder.toString();

        // if (strs == null || strs.length == 0) {
        //     return "";
        // }

        // String prefix = strs[0];

        // for (int i = 1; i < strs.length; i++) {
        //     while(!strs[i].startsWith(prefix)) {
        //         prefix = prefix.substring(0, prefix.length() -1);
        //         if(prefix == "") {
        //             return "";
        //         }
        //     }
        // }

        // return prefix;
    }
}