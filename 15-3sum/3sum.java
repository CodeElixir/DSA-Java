class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);
                if (set.contains(target)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
                    triplet.sort(null);
                    st.add(triplet);
                } else {
                    set.add(nums[j]);
                }
            }
        }
        return new ArrayList<List<Integer>>(st);
    }
}