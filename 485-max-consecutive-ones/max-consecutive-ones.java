class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }
            else {
                res = Math.max(count, res);
                count = 0;
            }
        }
        return Math.max(count, res);
    }
}