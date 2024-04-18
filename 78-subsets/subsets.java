class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsetsHelper(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private void subsetsHelper(int[] nums, int i, List<Integer> subset, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subsetsHelper(nums, i + 1, subset, subsets);
        subset.add(nums[i]);
        subsetsHelper(nums, i + 1, subset, subsets);
        subset.remove(subset.size() - 1);
    }
}