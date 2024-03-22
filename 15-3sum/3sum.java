class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Using Hashing
        // Set<List<Integer>> st = new HashSet<>();
        // for (int i = 0; i < nums.length; i++) {
        //     Set<Integer> set = new HashSet<>();
        //     for (int j = i + 1; j < nums.length; j++) {
        //         int target = -(nums[i] + nums[j]);
        //         if (set.contains(target)) {
        //             List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
        //             triplet.sort(null);
        //             st.add(triplet);
        //         } else {
        //             set.add(nums[j]);
        //         }
        //     }
        // }
        // return new ArrayList<List<Integer>>(st);

        // Using two-pointers
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            };
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[j] + nums[k] + nums[i];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    list.add(triplet);
                    j++;
                    k--;
                    while (j < k && (nums[j] == nums[j - 1])) j++;
                    while (j < k && (nums[k] == nums[k + 1])) k--;
                }
            }
        }
        return list;
    }
}