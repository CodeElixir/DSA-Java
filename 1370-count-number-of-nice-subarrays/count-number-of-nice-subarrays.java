class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarraysLesserThanK(nums, k) - numberOfSubarraysLesserThanK(nums, k - 1);
    }

    private int numberOfSubarraysLesserThanK(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                cnt++;
            }

            while (cnt > k) {
                if (nums[left++] % 2 != 0) {
                    cnt--;
                }
            }
            res += i - left + 1;
        }
        return res;
    }
}