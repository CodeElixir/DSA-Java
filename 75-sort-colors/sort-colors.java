class Solution {
    public void sortColors(int[] nums) {
        // Brute Force
        // int[] temp = new int[3];
        // for (int ele : nums) {
        //     temp[ele]++;
        // }

        // int i = 0;
        // while (temp[0] != 0) {
        //     nums[i++] = 0;
        //     temp[0]--;
        // }

        // while (temp[1] != 0) {
        //     nums[i++] = 1;
        //     temp[1]--;
        // }

        // while (temp[2] != 0) {
        //     nums[i++] = 2;
        //     temp[2]--;
        // }

        // Efficient
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}