class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int openCnt = 0;
        for (char ch : s.toCharArray()) {
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