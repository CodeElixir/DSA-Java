class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            if (i < nums.length) {
                nge[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % nums.length]);
        }
        return nge;
    }
}