class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        int openCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (openCnt > 0) {
                    builder.append(ch);
                }
                openCnt++;
            } else {
                if (openCnt > 1) {
                    builder.append(ch);
                }
                openCnt--;
            }   
        }
        return builder.toString();
    }
}