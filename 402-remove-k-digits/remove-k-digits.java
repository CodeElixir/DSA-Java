class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!stack.isEmpty() && k > 0 && (int)stack.peek() > (int)ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }

        
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder builder = new StringBuilder(stack.size());
        while(!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
              
        while(builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}