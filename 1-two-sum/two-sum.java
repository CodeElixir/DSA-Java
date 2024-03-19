class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (map.containsKey(val)) {
                res[0] = i;
                res[1] = map.get(val);
                break;
            } 
            map.put(nums[i], i);
        }
        return res;
    }
}