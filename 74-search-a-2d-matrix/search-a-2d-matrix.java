class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = (n * m) - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int midElement = matrix[mid / m][mid % m];
            if (target == midElement) {
                return true;
            } else if (target < midElement) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}