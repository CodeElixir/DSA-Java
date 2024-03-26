class Solution {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count  = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count = 1;
                continue;
            }
            count = (nums[i] == majority) ? count + 1 : count - 1;
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority) count++;
        }

        return count > nums.length / 2 ? majority : -1;

    }
}