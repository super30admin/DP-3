// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int case1,case2,ans = Integer.MAX_VALUE;
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0)
                    case1 = Integer.MAX_VALUE;
                else
                    case1 = matrix[i-1][j-1];
                if(j == n - 1)
                    case2= Integer.MAX_VALUE;
                else
                    case2 = matrix[i-1][j+1];
                matrix[i][j] += Math.min(matrix[i-1][j],Math.min(case1,case2));         }
        }
        for(int j = 0; j < n; j++)
            ans = Math.min(ans,matrix[m-1][j]);
        return ans;

    }
}