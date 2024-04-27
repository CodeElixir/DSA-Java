class Solution {
    // public List<List<String>> partition(String s) {
    //     List<List<String>> answer = new ArrayList<>();
    //     partitionHelper(s, 0, new ArrayList<>(), answer);
    //     return answer;
    // }

    // private void partitionHelper(String s, int pos, List<String> palindromes, List<List<String>> answer) {
    //     if (pos == s.length()) {
    //         answer.add(new ArrayList<>(palindromes));
    //         return;
    //     }

    //     for (int i = pos; i < s.length(); i++) {
    //         String subStr = s.substring(pos, i + 1);
    //         if (isPalindrome(subStr)) {
    //             palindromes.add(subStr);
    //             partitionHelper(s, i + 1, palindromes, answer);
    //             palindromes.remove(palindromes.size() - 1);
    //         }
    //     }
    // }

    // private boolean isPalindrome(String s) {
    //     int i = 0;
    //     int j = s.length() - 1;
    //     while (i <= j) {
    //         if (s.charAt(i) == s.charAt(j)) {
    //             i++;
    //             j--;
    //         } else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    public List<List<String>> partition(String s) {
        // Backtracking
        // Edge case
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }
    public void helper(String s, List<String> step, List<List<String>> result) {
        // Base case
        if(s == null || s.length() == 0) {
            result.add(new ArrayList<>(step));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) continue; // only do backtracking when current string is palindrome
            
            step.add(temp);  // choose
            helper(s.substring(i, s.length()), step, result); // explore
            step.remove(step.size() - 1); // unchoose
        }
        return;
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}