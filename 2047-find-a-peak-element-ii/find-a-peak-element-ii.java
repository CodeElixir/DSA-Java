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
        return maxIndex;
    }
}

// class Solution {
//     public int[] findPeakGrid(int[][] mat) {
//         int startCol = 0, endCol = mat[0].length-1;
        
//         while(startCol <= endCol){
//             int maxRow = 0, midCol = startCol + (endCol-startCol)/2;
            
//             for(int row=0; row<mat.length; row++){
//                  maxRow = mat[row][midCol] >= mat[maxRow][midCol]? row : maxRow;  
//             }
            
//             boolean leftIsBig    =   midCol-1 >= startCol  &&  mat[maxRow][midCol-1] > mat[maxRow][midCol];
//             boolean rightIsBig   =   midCol+1 <= endCol    &&  mat[maxRow][midCol+1] > mat[maxRow][midCol];
            
//             if(!leftIsBig && !rightIsBig)   // we have found the peak element
//                 return new int[]{maxRow, midCol};
            
//             else if(rightIsBig)  // if rightIsBig, then there is an element in 'right' that is bigger than all the elements in the 'midCol', 
//                 startCol = midCol+1; //so 'midCol' cannot have a 'peakPlane'
            
//             else // leftIsBig
//                 endCol = midCol-1;
//         }
//         return null;
//     }
// }