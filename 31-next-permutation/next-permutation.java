class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(0, nums.length - 1, nums);
        } else {
            for (int i = nums.length - 1; i >= index; i--) {
                if (nums[i] > nums[index]) {
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
            reverse(index + 1, nums.length - 1, nums);
        }

    }

    private static void reverse(int i, int j, int[] arr) {
        while (i < j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }
    }  
}