class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            freq[chars[i]]++;
            if (isDistinct(freq)) {
                right++;
            } else {
                maxLen = Math.max(maxLen, right - left);
                while (!isDistinct(freq)) {
                    freq[chars[left++]]--;
                }
                right++;  
            }
        }
        return maxLen = Math.max(maxLen, right - left);
    }

    private boolean isDistinct(int[] freq) {
        for (int i : freq) {
            if (i != 0 && i != 1) {
                return false;
            }
        }
        return true;
    }
}