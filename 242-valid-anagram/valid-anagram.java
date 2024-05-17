class Solution {
    private static final int CHAR = 256;

    public boolean isAnagram(String s, String t) {

        if (t.length() != s.length()) {
            return false;
        }

        int[] freq1 = new int[CHAR];
        int[] freq2 = new int[CHAR];
        for (int i = 0; i < t.length(); i++) {
            freq1[s.charAt(i)]++;
            freq2[t.charAt(i)]++;
        }

        for (int i = t.length(); i < s.length(); i++) {
            if (areEqual(freq1, freq2)) {
                return true;
            }

            freq1[s.charAt(i)]++;
            freq1[i - t.length()]--;
        }

        return areEqual(freq1, freq2);
    }

    private boolean areEqual(int[] freq1, int[] freq2) {
        boolean flag = true;
        for (int j = 0; j < CHAR; j++) {
            if (freq1[j] != freq2[j]) {
                flag = false;
                break;
            }
        }
        return flag;        
    }
}