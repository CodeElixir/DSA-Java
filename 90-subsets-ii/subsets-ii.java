class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(0, nums, new ArrayList<>(), subsets);
        return subsets;
    }

    private void subsetsWithDupHelper(int pos, int[] nums, List<Integer> subset, List<List<Integer>> subsets) {
        if (pos == nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[pos]);
        subsetsWithDupHelper(pos + 1, nums, subset, subsets);
        subset.remove(subset.size() - 1);
        int nextPos = pos;
        while (nums[pos] == nums[nextPos]) {
            nextPos++;
            if (nextPos >= nums.length) {
                break;
            }
        }
        subsetsWithDupHelper(nextPos, nums, subset, subsets);
    }
}