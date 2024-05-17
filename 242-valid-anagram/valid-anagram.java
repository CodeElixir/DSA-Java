class Solution {
    private static final int CHAR = 256;

    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }

        int[] freq1 = new int[CHAR];
        for (int i = 0; i < t.length(); i++) {
            freq1[s.charAt(i)]++;
            freq1[t.charAt(i)]--;
        }

        for (int i = 0; i < CHAR; i++) {
            if (freq1[i] != 0) {
                return false;
            }
        }
        return true;
    }
}