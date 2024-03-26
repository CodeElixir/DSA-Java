class Solution {
    public void sortColors(int[] nums) {
        // Brute Force
        int[] temp = new int[3];
        for (int ele : nums) {
            temp[ele]++;
        }

        int i = 0;
        while (temp[0] != 0) {
            nums[i++] = 0;
            temp[0]--;
        }

        while (temp[1] != 0) {
            nums[i++] = 1;
            temp[1]--;
        }

        while (temp[2] != 0) {
            nums[i++] = 2;
            temp[2]--;
        }
    }
}