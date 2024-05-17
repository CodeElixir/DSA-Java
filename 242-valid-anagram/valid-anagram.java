class Solution {
    private static final int CHAR = 256;

    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length()) {
            return false;
        }

        int[] freq1 = new int[CHAR];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            freq1[(int) sArr[i]]++;
            freq1[(int) tArr[i]]--;
        }

        for (int i = 0; i < CHAR; i++) {
            if (freq1[i] != 0) {
                return false;
            }
        }
        return true;
    }
}