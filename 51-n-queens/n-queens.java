class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> configurations = new ArrayList<>();
        solveNQueensHelper(0, new int[n][n], n, configurations);
        return configurations;
    }

    private void solveNQueensHelper(int i, int[][] configuration, int n, List<List<String>> configurations) {
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
            if (isSafe(i, j, configuration, n)) {
                configuration[i][j] = 1;
                solveNQueensHelper(i + 1, configuration, n, configurations);
                configuration[i][j] = 0;
            }
        }
    }

    private boolean isSafe(int i, int j, int[][] configuration, int n) {
        int tempI = i;
        int tempJ = j;
        
        // UP
        while (tempI >= 0) {
            if (configuration[tempI][tempJ] == 1) {
                return false;
            }
            tempI--;
        }

        tempI = i;
        tempJ = j;

        // TOP RIGHT
        while (tempI >= 0 && tempJ <= n - 1) {
            if (configuration[tempI][tempJ] == 1) {
                return false;
            }
            tempI--;
            tempJ++;
        }

        tempI = i;
        tempJ = j;

        // TOP LEFT
        while (tempI >= 0 && tempJ >= 0) {
            if (configuration[tempI][tempJ] == 1) {
                return false;
            }
            tempI--;
            tempJ--;
        }

        return true;
    }
}