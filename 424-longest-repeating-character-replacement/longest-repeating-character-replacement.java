class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int left = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            freq[chars[i] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[chars[i] - 'A']);
            // i - left + 1 - maxFreq ==> len - maxCharFreq ==> minimum no of conversions
            if ((i - left + 1) - maxFreq > k) {
                freq[chars[left] - 'A']--;
                left++;
            }

            if ((i - left + 1 )- maxFreq <= k) {
                res = Math.max(res, i - left + 1);
            }

        }
        return res;
    }
}