class Solution {
    public int maximalRectangle(char[][] matrix) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxRectangle = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = Character.digit(matrix[i][j], 10);
                heights[j] = (i == 0) ? val : (val == 0 ? val : Character.digit(matrix[i][j], 10) + heights[j]);
            }
            maxRectangle = Math.max(largestRectangleArea(heights, stack), maxRectangle);
        }
        return maxRectangle;
    }

    private int largestRectangleArea(int[] heights, Deque<Integer> stack) {
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