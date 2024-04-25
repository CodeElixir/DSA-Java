class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    // private void combinationSumHelper(int[] candidates, int target, int pos, List<Integer> combination, 
    //                                   List<List<Integer>> combinations) {
    //     if (pos == candidates.length) {
    //         if (target == 0) {
    //             combinations.add(new ArrayList<>(combination));
    //         }
    //         return;
    //     }

    //     if (target == 0) {
    //         combinations.add(new ArrayList<>(combination));
    //         return;
    //     }
        
    //     // Picking up the element at current index
    //     if (candidates[pos] <= target) {
    //         combination.add(candidates[pos]);
    //         combinationSumHelper(candidates, target - candidates[pos], pos + 1, combination, combinations);
    //         combination.remove(combination.size() - 1);
    //     } else {
    //         return;
    //     }

    //     int newPos = pos;
    //     while (candidates[newPos] == candidates[pos]) {
    //         newPos++;
    //         if (newPos >= candidates.length) {
    //             return;
    //         }          
    //     }

    //     // Not picking up the element at current index
    //     combinationSumHelper(candidates, target, newPos, combination, combinations);
    // }

    private void combinationSumHelper(int[] arr, int target, int ind, List<Integer> ds, 
                                      List<List<Integer>> ans) {        
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            // findCombinations(i + 1, arr, target - arr[i], ans, ds);
            combinationSumHelper(arr, target - arr[i], i + 1, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}