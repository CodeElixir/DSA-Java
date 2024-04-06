// class Solution {
//     public String removeOuterParentheses(String s) {
//         StringBuilder res = new StringBuilder();
//         int openCnt = 0;
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if (ch == '(') {
//                 openCnt++;
//                 if (openCnt > 1) res.append(ch);
//             } else {
//                 if (openCnt > 1) res.append(ch);
//                 openCnt--;
//             }
//         }
//         return res.toString();
//     }
// }
class Solution {
        public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            // if (c == '(' && opened++ > 0) s.append(c);
            // if (c == ')' && opened-- > 1) s.append(c);
            if(c == '(') {
                if(opened > 0) s.append(c);
                opened++;
            } else {
                if(opened > 1) s.append(c);
                opened--;
            }
        }
        return s.toString();
    }
}