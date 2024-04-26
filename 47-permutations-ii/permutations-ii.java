class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(nums, visited, new ArrayList<>(), permutations);
        return permutations;   
    }

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