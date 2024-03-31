class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int[] temp = new int[nums.length];
        int i = 0;
        int j = nums.length / 2;
        int k = 0;
        while (k < nums.length) {
            if (nums[k] < 0) {
                temp[j++] = nums[k];
            } else {
                temp[i++] = nums[k];
            }
            k++;
        }
        i = 0;
        j = nums.length / 2;
        k = 0;
        while (k < nums.length) {
            res[k] = temp[i++];
            res[k + 1] = temp[j++];
            k = k + 2;
        }
        return res;
    }
}