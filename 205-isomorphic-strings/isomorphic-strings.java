class Solution {
    private static int CHAR = 256;
    public boolean isIsomorphic(String s, String t) {
        int[] chars1 = new int[CHAR];
        int[] chars2 = new int[CHAR];
        for (int i = 0; i < s.length(); i++) {
            int ch1 = s.charAt(i);
            int ch2 = t.charAt(i);
            if (chars1[ch1] != chars2[ch2]) {
                return false;
            }
            chars1[ch1] = i + 1;
            chars2[ch2] = i + 1;
        }
        return true;
    }
}