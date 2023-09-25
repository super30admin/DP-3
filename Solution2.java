// Leetcode Problem :  https://leetcode.com/problems/minimum-falling-path-sum/description/
// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * I start traversing from the first row of the matrix, I obtain the minimum from elements that are directly above or diagonally left/right in the 
 * previous row and add the value of current element to it. After doing this, I obtain the minimum of the last row and return that
 * as the answer.
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<columns;j++)
            {
                if(j==0)
                {
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                else if(j==columns-1)
                {
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else
                {
                    matrix[i][j]+=Math.min(matrix[i-1][j],Math.min(matrix[i-1][j+1],matrix[i-1][j-1]));
                }
            }
        }


        int min = Integer.MAX_VALUE;
        for(int i=0;i<columns;i++)
        {
            min=Math.min(min,matrix[rows-1][i]);
        }
        return min;
    }
}