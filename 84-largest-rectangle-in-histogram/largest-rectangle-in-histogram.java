class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int j = stack.pop();
                int left = stack.isEmpty() ? j + 1 : j - stack.peek();
                int right = i - j - 1;
                int currArea = heights[j] * (left + right);
                maxArea = Math.max(maxArea, currArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            int left = stack.isEmpty() ? j + 1 : j - stack.peek();
            int right = heights.length - j - 1;
            int currArea = heights[j] * (left + right);
            maxArea = Math.max(maxArea, currArea);            
        }

        return maxArea;
    }
}