class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            lastSeen[chars[i] - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                cnt = cnt + 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
        }
        return cnt;
    }
}