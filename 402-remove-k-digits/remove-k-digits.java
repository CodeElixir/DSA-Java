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
        // char[] res = new char[stack.size()];
        StringBuilder builder = new StringBuilder(stack.size());
        // int i = stack.size() - 1;
        while(!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        // System.out.println(builder.charAt(0) + "--" + builder);
              
        while(builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}