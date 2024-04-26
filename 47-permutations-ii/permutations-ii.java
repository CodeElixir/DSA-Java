class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permutations = new HashSet<>();
        permuteHelper(0, nums, permutations);
        return new ArrayList<>(permutations);   
    }

    private void permuteHelper(int pos, int[] nums, Set<List<Integer>> permutations) {
        if (pos == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int ele : nums) {
                list.add(ele);
            }
            permutations.add(list);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[pos]) {
                continue;
            }
            swap(pos, i, nums);
            permuteHelper(pos + 1, nums, permutations);
            swap(pos, i, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}