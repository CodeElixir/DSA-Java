class Solution {
    private static int CHAR = 128;

    public String frequencySort(String s) {
        // Method - 1
        // int[] freqArr = new int[CHAR];
        // StringBuilder res = new StringBuilder(s.length());
        // for (char ch : s.toCharArray()) {
        //     freqArr[ch]++;
        // }
        // List<List<Character>> buckets = Stream.generate(() -> new ArrayList<Character>())
        //                                 .limit(s.length() + 1)
        //                                 .collect(Collectors.toList());

        // for (int i = 0; i < CHAR; i++) {
        //     char ch = (char) i;
        //     int freq = freqArr[i];
        //     if (freq != 0) {
        //         List<Character> chars = buckets.get(freq);
        //         chars.add(ch);
        //     }
        // }

        // for (int i = buckets.size() - 1; i >= 0; i--) {
        //     List<Character> chars = buckets.get(i);
        //     for (int j = 0; j < chars.size(); j++) {
        //         char ch = chars.get(j);
        //         int cnt = i;
        //         while(cnt != 0) {
        //             res.append(ch);
        //             cnt--;
        //         }
        //     }
        // }
        // return res.toString();

        // Method - 2
        // int[] freqArr = new int[CHAR];
        // StringBuilder res = new StringBuilder(s.length());
        // for (char ch : s.toCharArray()) {
        //     freqArr[ch]++;
        // }

        // for (int ch : s.toCharArray()) {
        //     int maxIndex = 0;
        //     for (int i = 0; i < CHAR; i++) {
        //         if (freqArr[i] > freqArr[maxIndex]) {
        //             maxIndex = i;
        //         }
        //     }

        //     while(freqArr[maxIndex] != 0) {
        //         res.append((char) maxIndex);
        //         freqArr[maxIndex]--;
        //     }
        // }
        // return res.toString();

        char str[]=s.toCharArray();
        StringBuilder res = new StringBuilder(s.length());
        int freq[]=new int[128];
        for(int i=0;i<str.length;i++)
        {
            freq[str[i]]++;
        }
        
        for(int i=0;i<str.length;i++)
        {
            char c=',';
            
            for(int j=0;j<freq.length;j++)
            {
                if(freq[j]>freq[c])
                {
                    c=(char)j;
                }
            }
            
            while(freq[c]!=0)
            {
                res.append(c);
                freq[c]--;
            }
        }
        return res.toString();
    }
    
}