class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            // if mid element is target return immediately.
            if (target == nums[mid]) {
                return true;
            } else if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;  
            } else if (nums[mid] >= nums[low]) { // Check which part is sorted.
                // Left part is sorted
                // Check target is withing the range of this sorted part. Update the search space accordingly.
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // Right part is sorted
                // Check target is withing the range of this sorted part. Update the search space accordingly.
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }                
            }
        }
        return false;        
    }
}