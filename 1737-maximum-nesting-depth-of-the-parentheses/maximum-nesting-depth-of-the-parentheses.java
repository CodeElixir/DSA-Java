class Solution {
    public int maxDepth(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int mxDpt = 0;
        int depth = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                depth++;
            } else if (ch == ')') {
                stack.pop();
                mxDpt = Math.max(mxDpt, depth);
                depth--;
            }
        }
        return mxDpt;
    }
}