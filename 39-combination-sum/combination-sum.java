class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void combinationSumHelper(int[] candidates, int target, int pos, List<Integer> combination, 
                                      List<List<Integer>> combinations) {
        if (pos == candidates.length) {
            if (target == 0) {
                combinations.add(new ArrayList<>(combination));
            }
            return;
        }

        // Picking up the element at current index
        if (candidates[pos] <= target) {
            combination.add(candidates[pos]);
            combinationSumHelper(candidates, target - candidates[pos], pos, combination, combinations);
            combination.remove(combination.size() - 1);
        }

        // Not picking up the element at current index
        combinationSumHelper(candidates, target, pos + 1, combination, combinations);
    }
}