class Solution {
    private static int CHAR = 128;

    public String frequencySort(String s) {
        int[] freqArr = new int[256];
        StringBuilder res = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            freqArr[ch]++;
        }
        List<List<Character>> buckets = Stream.generate(() -> new ArrayList<Character>())
                                        .limit(s.length() + 1)
                                        .collect(Collectors.toList());

        for (int i = 0; i < CHAR; i++) {
            char ch = (char) i;
            int freq = freqArr[i];
            if (freq != 0) {
                List<Character> chars = buckets.get(freq);
                chars.add(ch);
            }
        }

        for (int i = buckets.size() - 1; i >= 0; i--) {
            List<Character> chars = buckets.get(i);
            for (int j = 0; j < chars.size(); j++) {
                char ch = chars.get(j);
                int cnt = i;
                while(cnt != 0) {
                    res.append(ch);
                    cnt--;
                }
            }
        }
        return res.toString();
    }
    
}