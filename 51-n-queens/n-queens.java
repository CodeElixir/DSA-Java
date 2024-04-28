class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> configurations = new ArrayList<>();
        // Optimisation arrays
        int[] col = new int[n];
        int[] topLeft = new int[2 * n];
        int[] topRight = new int[2 * n];
        solveNQueensHelper(0, new int[n][n], n, configurations, col, topLeft, topRight);
        return configurations;
    }

    private void solveNQueensHelper(int i, int[][] configuration, int n, List<List<String>> configurations, 
    int[] col, int[] topLeft, int[] topRight) {
        if (i == n) {
            List<String> res = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                StringBuilder row = new StringBuilder();
                for (int k = 0; k < n; k++) {
                    char position = configuration[j][k] == 1 ? 'Q' : '.';
                    row.append(position);
                }
                res.add(row.toString());
            }
            configurations.add(res);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isSafe(i, j, n, col, topLeft, topRight)) {
                configuration[i][j] = 1;
                col[j] = topLeft[(i - j) + (n - 1)] = topRight[i + j] = 1;
                solveNQueensHelper(i + 1, configuration, n, configurations, col, topLeft, topRight);
                configuration[i][j] = 0;
                col[j] = topLeft[(i - j) + (n - 1)] = topRight[i + j] = 0;
            }
        }
    }

    private boolean isSafe(int i, int j, int n, int[] col, int[] topLeft, int[] topRight) {
        return col[j] == 0 && topLeft[(i - j) + (n - 1)] == 0 && topRight[i + j] == 0;
    }
}