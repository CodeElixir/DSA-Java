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
            while ((i - left + 1) - maxFreq > k) {
                freq[chars[left] - 'A']--;
                left++;
            }

            if ((i - left + 1 ) - maxFreq <= k) {
                res = Math.max(res, i - left + 1);
            }

        }
        return res;

        // char[] c = s.toCharArray();
        // int[] seen = new int[26];
        // int maxCount = 0;
        // int max = Integer.MIN_VALUE;
        // int n = s.length();
        // int left = 0;
        // int right = 0;

        // while (right < n) {
        //     maxCount = Math.max(maxCount, ++seen[c[right] - 'A']);

        //     while (right - left + 1 - maxCount > k) {
        //         seen[c[left] - 'A']--;
        //         left++;
        //     }

        //     max = Math.max(max, right - left + 1);
        //     right++;
        // }

        // return max;
    }
}