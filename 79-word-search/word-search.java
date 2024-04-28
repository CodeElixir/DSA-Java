class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (wordSearch(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean wordSearch(int i, int j, int k, char[][] board, String word) {
        if (k == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '0') {
            return false;
        }

        char ch = board[i][j];
        
        if (word.charAt(k) != ch) {
            return false;
        }
        
        board[i][j] = '0';

        boolean right = wordSearch(i, j + 1, k + 1, board, word);
        boolean left = wordSearch(i, j - 1, k + 1, board, word);
        boolean top = wordSearch(i - 1, j, k + 1, board, word);
        boolean bottom = wordSearch(i + 1, j, k + 1, board, word);

        board[i][j] = ch;

        return right || left || top || bottom;
    }
}