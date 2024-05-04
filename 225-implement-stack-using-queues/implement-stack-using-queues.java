class MyStack {
    Deque<Integer> q1;

    public MyStack() {
        q1 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (q1.isEmpty()) {
            q1.add(x);
            return;
        }
        q1.add(x);
        int n = q1.size();
        for (int i = 1; i < n; i++) {
            q1.add(q1.remove());
        }
    }
    
    public int pop() {
        return q1.remove();
    }
    
    public int top() {
        return q1.element();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */