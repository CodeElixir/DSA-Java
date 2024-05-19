class Solution {
    public int maxDepth(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int mxDpt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
            }
            mxDpt = Math.max(mxDpt, stack.size());
        }
        return mxDpt;
    }
}