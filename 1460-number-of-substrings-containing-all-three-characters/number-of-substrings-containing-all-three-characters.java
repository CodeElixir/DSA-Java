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

    // public static int countSubstring(String s){
    //     // Write your code here.
    //     // to find the tot subarray count
    //     int res = s.length()*(s.length()+1)/2;
    //     // return tot subarray - subarray which has atmost any 2 characters from a,b,c.
    //     return res-solve(s);
    // }
    // // function to find a subarray which has atmost any 2 character from a,b,c
    // public static int solve(String s){
    //     HashMap<Character,Integer> map = new HashMap<>();
    //     int left=0,count=0;
    //     for(int right=0;right<s.length();right++){
    //         map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)+1);
    //         while(map.size()>2){
    //             map.put(s.charAt(left), map.get(s.charAt(left))-1);
    //             if(map.get(s.charAt(left))==0) map.remove(s.charAt(left));
    //             left++;
    //         }
    //         count+=right-left+1;
    //     }
    //     return count;
    // }
}