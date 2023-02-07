// Time Complexity : O(n*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No 

// Your code here along with comments explaining your approach
//followed bottom-up approach, calculated the min at each point and went further

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int n = matrix.length;
        for (int i = n - 2; i >= 0; i--) {
            int ind = i + 1;
            matrix[i][0] += Math.min(matrix[ind][0], matrix[ind][1]);
            System.out.print(matrix[i][0]);
            for (int j = 1; j < n - 1; j++) {
                matrix[i][j] += Math.min(matrix[ind][j - 1], Math.min(matrix[ind][j], matrix[ind][j + 1]));
                System.out.print(" " + matrix[i][j]);
            }
            matrix[i][n - 1] += Math.min(matrix[ind][n - 1], matrix[ind][n - 2]);
            // System.out.print(" "+matrix[in])
        }
        for (int i = 0; i < n; i++)
            ans = Math.min(ans, matrix[0][i]);

        return ans;
    }
}