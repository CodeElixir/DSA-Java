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
    public String removeOuterParentheses(String s) {
       StringBuilder res = new StringBuilder();
        int len = s.length();
        char[] ch = s.toCharArray();
        for(int i=0; i<len; )
            i = findSubString(ch,i,res,len);
        
        return res.toString();
    }
    
    public int findSubString(char ch[], int i, StringBuilder res,int len){
        int open=1,j=i+1;
        
        while(open!=0){
            if(ch[j++]=='(') open++;
            else    open--;
        }
        if(j-i!=0)  res.append(ch, ++i, j-i-1);
        
        return j;
    }
}