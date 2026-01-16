// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        // Start from second row
        for (int i=1;i<n;i++) {
            for (int j=0;j<n;j++) {
                // down(i+1,j)
                // down-left(i+1,j-1)
                // down-right(i+1,j+1)
                int up=matrix[i-1][j];
                int left=(j>0)?matrix[i-1][j-1]:Integer.MAX_VALUE;
                int right =(j<n-1)?matrix[i-1][j+1]: Integer.MAX_VALUE;
                // Add minimum of possible paths
                matrix[i][j] += Math.min(up, Math.min(left, right));
            }
        }
        // Answer is minimum in last row
        int ans = Integer.MAX_VALUE;
        for (int j=0; j<n;j++) {
            ans=Math.min(ans,matrix[n - 1][j]);
        }
        return ans;
    }
}

