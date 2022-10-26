// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;

        //matrix[i][j] = minimum falling path sum to reach i,j cell from 0th row

        for(int i = 1; i < n; ++i){
            for(int j = 0; j < n ; ++j){
                int diagLeft = j==0 ? Integer.MAX_VALUE : matrix[i-1][j-1];
                int up = matrix[i-1][j];
                int diagRight = j==n-1 ? Integer.MAX_VALUE : matrix[i-1][j+1];

                matrix[i][j] += Math.min(
                    diagLeft,
                    Math.min(up, diagRight)
                );
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < n; ++j){
            ans = Math.min(ans, matrix[n-1][j]);
        }

        return ans;
    }
}
