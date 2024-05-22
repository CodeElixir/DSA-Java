class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarraysWithLesserThanEqualKDistinct(nums, k) - subarraysWithLesserThanEqualKDistinct(nums, k - 1);
    }
    
    private int subarraysWithLesserThanEqualKDistinct(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        
        int res = 0;
        int left = 0;
        int cnt = 0;
        int[] freq = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            if (freq[nums[i]] == 1) {
                cnt++;
            }
            while (cnt > k) {
                freq[nums[left]]--;
                if (freq[nums[left++]] == 0) {
                    cnt--;
                }
            }
            res = res + (i - left + 1);
        }

        return res;
    }

    // private int subarraysWithLesserThanEqualKDistinct(int[] nums, int k) {
    //     if (k < 0) {
    //         return 0;
    //     }
        
    //     int cnt = 0;
    //     int left = 0;
    //     Map<Integer,Integer> map = new HashMap<>(nums.length);
        
    //     for (int i = 0; i < nums.length; i++) {
    //         map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    //         while (map.size() > k) {
    //             map.put(nums[left], map.get(nums[left]) - 1);
    //             if (map.get(nums[left]) == 0) {
    //                 map.remove(nums[left]);
    //             }
    //             left++;
    //         }
    //         cnt = cnt + (i - left + 1);
    //     }

    //     return cnt;
    // }
}