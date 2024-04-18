class Solution {
    public List<String> generateParenthesis(int n) {
         int openCount = 0;
         int closeCount = 0;
         List<String> answer = new ArrayList<>();
         generateParenthesisHelper(openCount, closeCount, new StringBuilder(), n, answer);
         return answer;
    }

    private void generateParenthesisHelper(int openCount, int closeCount, StringBuilder parenthesis, 
                                            int n, List<String> answer) {
        if (openCount == n && openCount == closeCount) {
            answer.add(parenthesis.toString());
            return;
        }

        if (openCount < n) {
            parenthesis.append("(");
            generateParenthesisHelper(openCount + 1, closeCount, parenthesis, n, answer);
            parenthesis.deleteCharAt(parenthesis.length() - 1);
        }

        if (openCount > closeCount) {
            parenthesis.append(")");
            generateParenthesisHelper(openCount, closeCount + 1, parenthesis, n, answer);
            parenthesis.deleteCharAt(parenthesis.length() - 1); 
        }
    }
}