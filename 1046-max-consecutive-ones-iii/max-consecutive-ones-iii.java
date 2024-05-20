class Solution {
    public int longestOnes(int[] nums, int k) {
        // Method - 1
        // int left = 0;
        // int cnt = 0;
        // int max = 0;
        // int i;
        // for (i = 0; i < nums.length; i++) {
        //     if (cnt == k && nums[i] == 0) {
        //         max = Math.max(max, i - left);
        //         while (cnt != k - 1) {
        //             if (nums[left++] == 0) {
        //                 cnt--;
        //             }
        //         } 
        //     }

        //     if (nums[i] == 0) {
        //         cnt++;
        //     }
        // }

        // if (cnt != k && cnt > 0) {
        //     return nums.length;
        // }
        // return Math.max(max, i - left);

        // Method - 2
        // int left = 0;
        // int cnt = 0;
        // int max = 0;
        // int i;

        // for (i = 0; i < nums.length; i++) {

        //     if (nums[i] == 0) {
        //         cnt++;
        //     }

        //     while (cnt > k) {
        //         if (nums[left++] == 0) {
        //             cnt--;
        //         }
        //     }

        //     if (cnt <= k) {
        //         max = Math.max(max, i - left + 1);
        //     }
        // }
        // return max;

        // Method - 3
        int left = 0;
        int cnt = 0;
        int max = 0;
        int i;

        for (i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                cnt++;
            }

            if (cnt > k) {
                if (nums[left++] == 0) {
                    cnt--;
                }
            }

            if (cnt <= k) {
                max = Math.max(max, i - left + 1);
            }
        }
        return max;
    }
}