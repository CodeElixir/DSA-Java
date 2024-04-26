class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        permuteHelper(0, nums, permutations);
        return permutations;
    }

    private void permuteHelper(int pos, int[] nums, List<List<Integer>> permutations) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int ele : nums) {
                list.add(ele);
            }
            permutations.add(list);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
            permuteHelper(pos + 1, nums, permutations);
            temp = nums[i];
            nums[i] = nums[pos];
            nums[pos] = temp;
        }
    }
}