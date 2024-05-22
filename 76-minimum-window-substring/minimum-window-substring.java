class Solution {
    public String minWindow(String s, String t) {
        int[] freq = new int[128];
        for (int ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int cnt = 0;
        char[] chars = s.toCharArray();
        
        for (int i = 0; i < s.length(); i++) {
            freq[chars[i]]--;
            if (freq[chars[i]] >= 0) {
                cnt++;
            }
            while (cnt == t.length()) {
                freq[chars[left]]++;
                if (freq[chars[left]] == 1) {
                    cnt--;
                }
                if ((i - left + 1) < minLength) {
                    minLength = i - left + 1;
                    startIndex = left; 
                }
                left++;
            }
        }

        if (startIndex == -1) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);
    }
}