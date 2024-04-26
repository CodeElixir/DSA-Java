class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(nums, visited, new ArrayList<>(), permutations);
        return permutations;   
    }

    // Brute force
    // private void permuteHelper(int pos, int[] nums, Set<List<Integer>> permutations) {
    //     if (pos == nums.length) {
    //         List<Integer> list = new ArrayList<>();
    //         for (int ele : nums) {
    //             list.add(ele);
    //         }
    //         permutations.add(list);
    //         return;
    //     }

    //     for (int i = pos; i < nums.length; i++) {
    //         if (i > pos && nums[i] == nums[pos]) {
    //             continue;
    //         }
    //         swap(pos, i, nums);
    //         permuteHelper(pos + 1, nums, permutations);
    //         swap(pos, i, nums);
    //     }
    // }

    // private void swap(int i, int j, int[] nums) {
    //     int t = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = t;
    // }

    private void permuteHelper(int[] nums, boolean[] visited, List<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) continue;
            visited[i] = true;
            permutation.add(nums[i]);
            permuteHelper(nums, visited, permutation, permutations);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}