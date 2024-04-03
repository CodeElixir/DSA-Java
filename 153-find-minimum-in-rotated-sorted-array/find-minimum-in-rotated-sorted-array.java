class Solution {
    public int findMin(int[] nums) {
        // int low = 0;
        // int high = nums.length - 1;
        // while (low <= high) {
        //     int mid = low + ((high - low) / 2);
        //     if ((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
        //         return nums[mid];
        //     } else if (nums[mid] >= nums[low] && nums[mid] >= nums[high]) {
        //         low = mid + 1;
        //     } else {
        //         high = mid - 1;
        //     }
        // }
        // return -1;
        
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] >= nums[low]) {
                // Left half is sorted. Pick min and eliminate this half.
                min = Math.min(nums[low], min);
                low = mid + 1;
            } else {
                // Right half is sorted. Pick min and eliminate this half.
                min = Math.min(nums[mid], min);
                high = mid - 1;
            }
        }
        return min;
    }
}