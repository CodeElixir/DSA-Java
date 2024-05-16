class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        int openCnt = 0;
        for (char ch : s.toCharArray()) {
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