class StockSpanner {

    private Deque<List<Integer>> stack;
    private int index;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        index = 0;
    }
    
    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().get(0) <= price) {
            stack.pop();
        }
        int span = stack.isEmpty() ? index + 1 : index - stack.peek().get(1);
        List<Integer> list = new ArrayList<>(2);
        list.add(price);
        list.add(index);
        stack.push(list);
        index++;
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */