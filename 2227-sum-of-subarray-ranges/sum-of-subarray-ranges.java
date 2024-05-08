class Solution {
    public long subArrayRanges(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        long minSum = 0;
        long maxSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int j = stack.pop();
                long left = stack.isEmpty() ? j + 1 : j - stack.peek();
                long right = i - j;
                minSum = (minSum + (long) nums[j] * left * right);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            long left = stack.isEmpty() ? j + 1 : j - stack.peek();
            long right = nums.length - j;
            minSum = (minSum + (long) nums[j] * left * right);          
        }


        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int j = stack.pop();
                long left = stack.isEmpty() ? j + 1 : j - stack.peek();
                long right = i - j;
                maxSum = (maxSum + (long) nums[j] * left * right);   
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            long left = stack.isEmpty() ? j + 1 : j - stack.peek();
            long right = nums.length - j;
            maxSum = (maxSum + (long) nums[j] * left * right);            
        }

        return maxSum - minSum;
    }


}