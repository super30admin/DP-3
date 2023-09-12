// Time Complexity :
//O(n2)
// Space Complexity :
//O(1)
// Did this code successfully run on Leetcode :
//yes
// Any problem you faced while coding this :
//int min = Integer.MAX_VALUE; not sure why this is used to initialize? 


// Your code here along with comments explaining your approach


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        for(int i = n-2;i>=0;i--) {
            for(int j=0;j<n;j++) {
                //condition for left edge
                if(j==0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j+1]);

                }
                //condition for right edge
                else if(j==n-1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],matrix[i+1][j-1]);
                }
                //Remaining all conditions included
                else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j-1],Math.min(matrix[i+1][j],matrix[i+1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0;j<n;j++) {
            min = Math.min(min,matrix[0][j]);
        }
        return min;
    }
}