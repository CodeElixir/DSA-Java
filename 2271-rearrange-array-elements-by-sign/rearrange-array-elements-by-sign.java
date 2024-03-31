class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Brute force
        // int[] res = new int[nums.length];
        // int[] temp = new int[nums.length];
        // int i = 0;
        // int j = nums.length / 2;
        // int k = 0;
        // while (k < nums.length) {
        //     if (nums[k] < 0) {
        //         temp[j++] = nums[k];
        //     } else {
        //         temp[i++] = nums[k];
        //     }
        //     k++;
        // }
        // i = 0;
        // j = nums.length / 2;
        // k = 0;
        // while (k < nums.length) {
        //     res[k] = temp[i++];
        //     res[k + 1] = temp[j++];
        //     k = k + 2;
        // }
        // return res;
        int[] res =  new int[nums.length];
        int positive = 0;
        int negative = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                res[negative] = nums[i];
                negative = negative + 2;
            } else {
                res[positive] = nums[i];
                positive = positive + 2;               
            }
        }
        return res;
    }
}