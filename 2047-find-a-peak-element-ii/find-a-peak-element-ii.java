class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int[] res = new int[2];
        int low = 0;
        int high = mat[0].length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int rowIndex = findMax(mat, mid);
            if ((mid == 0 || mat[rowIndex][mid] > mat[rowIndex][mid - 1]) && 
                (mid == mat[0].length - 1 || mat[rowIndex][mid] > mat[rowIndex][mid + 1])) {
                    res[0] = rowIndex;
                    res[1] = mid;
                    return res;
            } else if (mid != 0 && mat[rowIndex][mid] < mat[rowIndex][mid - 1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private int findMax(int[][] arr, int col) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][col] > arr[maxIndex][col]) {
                maxIndex = i;
            }
        }
        System.out.println(arr[maxIndex][col]);
        return maxIndex;
    }
}