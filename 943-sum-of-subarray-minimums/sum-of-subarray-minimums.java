class Solution {
    private static final long MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        long minSum = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int j = stack.pop();
                long left = stack.isEmpty() ? j + 1 : j - stack.peek();
                long right = i - j;
                minSum = (minSum + (long) arr[j] * left * right) % MOD;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            long left = stack.isEmpty() ? j + 1 : j - stack.peek();
            long right = arr.length - j;
            minSum = (minSum + (long) arr[j] * left * right) % MOD;
        }
        return (int) minSum;
    }
}