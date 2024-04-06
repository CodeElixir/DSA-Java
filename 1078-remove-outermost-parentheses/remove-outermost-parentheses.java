class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int openCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openCnt++;
                if (openCnt > 1) res.append(ch);
            } else {
                if (openCnt > 1) res.append(ch);
                openCnt--;
            }
        }
        return res.toString();
    }
}