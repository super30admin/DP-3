// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        //bottom up approach to cacluate min sum for the element and the next row element
        for(int i = matrix.length - 2;i >= 0;i--)
            for(int j = matrix[0].length - 1;j >= 0;j--){
                if(j == 0)
                    matrix[i][j] += Math.min(matrix[i + 1][j],matrix[i + 1][j + 1]);      
                else if(j == matrix[0].length - 1)
                    matrix[i][j] += Math.min(matrix[i + 1][j - 1],matrix[i + 1][j]);
                else
                    matrix[i][j] += Math.min(matrix[i + 1][j - 1],Math.min(matrix[i + 1][j],matrix[i+1][j + 1]));
        }

        //find the minimum in the first row
        for(int j = 0;j < matrix[0].length;j++)
            res = Math.min(res,matrix[0][j]);
    
        return res;
    }
}