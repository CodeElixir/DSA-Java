class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return numSubarraysLesserThanEqualSum(nums, goal) - numSubarraysLesserThanEqualSum(nums, goal - 1);
    }

    private int numSubarraysLesserThanEqualSum(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int res = 0;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum > goal) {
                sum -= nums[left++];
            }
            res += i - left + 1;
        }
        return res;
    } 
}