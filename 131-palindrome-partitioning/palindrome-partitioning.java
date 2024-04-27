class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void partitionHelper(String s, int pos, List<String> palindromes, List<List<String>> answer) {
        if (pos == s.length()) {
            answer.add(new ArrayList<>(palindromes));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            String subStr = s.substring(pos, i + 1);
            if (isPalindrome(subStr)) {
                palindromes.add(subStr);
                partitionHelper(s, i + 1, palindromes, answer);
                palindromes.remove(palindromes.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}