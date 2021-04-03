    /*
     *  Time Complexity: O(N*M) Where N is the number of rows and M is the number of columns.
     *  Space Complexity: O(1) Since we are mutaing the existing array with intermediate results.
     *
     *  Did this code successfully run on Leetcode : Yes
     *  Any problem you faced while coding this : Design the approach to hold the min element.
     *
     *  Explanation: For each value in the matrix we check the min value in the top row in indexes i, i-1 and i+1. Then we add the min value to the current value. We repeate the same till the last row. Once we complete this our result would be the min value in the last row.
     */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                int currMin=matrix[i-1][j];
                if(j!=0)currMin=Math.min(currMin, matrix[i-1][j-1]);
                if(j<matrix[0].length-1)currMin=Math.min(currMin, matrix[i-1][j+1]);
                matrix[i][j]+=currMin;
            }
        }
        int result=Integer.MAX_VALUE;;
        for(int j=0;j<matrix[0].length;j++){
            result = Math.min(result, matrix[matrix.length-1][j]);
        }
        return result;
    }
}
