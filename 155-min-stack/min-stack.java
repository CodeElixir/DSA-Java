class MinStack {
    private Stack<Long> stack;
    private long minElement;

    public MinStack() {
        stack = new Stack<>();
        minElement = Long.MAX_VALUE;    
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            minElement = (long) val;
            stack.push((long) val);
            return;
        } else if (val < minElement) {
            stack.push((2 * (long) val) - minElement);
            minElement = (long) val;
        } else {
            stack.push((long) val);
        }

    }
    
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        long popped = stack.pop();
        if (popped <= minElement) {
            minElement = stack.isEmpty() ? Long.MAX_VALUE: (2 * minElement) - popped;
        }
    }
    
    public int top() {
        long ele = stack.peek();
        if (ele < minElement) {
            return (int) minElement;
        }
        return (int) ele;
    }
    
    public int getMin() {
        return (int) minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */