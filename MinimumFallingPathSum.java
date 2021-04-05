// Time Complexity : O(2^mn) mn is the size of the matrix
// Space Complexity : O(n) n is the size of the recusion stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        for(int i=0;i<matrix[0].length;i++) {
            int val = DFS(matrix, 0, i);
            ans = Math.min(ans, val);
        }
        return ans;
    }
    public int DFS(int [][] matrix, int start, int end) {
        if(start < 0 || start >= matrix.length || end < 0 || end >= matrix[0].length) {
            return 101;
        }
        else if(start == matrix.length - 1) {
            return matrix[start][end];
        }
        return matrix[start][end] + Math.min(DFS(matrix, start + 1, end - 1), Math.min(DFS(matrix, start + 1, end), DFS(matrix, start + 1, end + 1)));
    }
}


// Time Complexity : O(mn) mn is the size of the matrix
// Space Complexity : O(n) n is the size of the recusion stack
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length + 1][matrix[0].length + 1];
        int ans = Integer.MAX_VALUE;
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        for(int i=0;i<matrix[0].length;i++) {
            int val = DFS(matrix, 0, i, dp);
            ans = Math.min(ans, val);
        }
        return ans;
    }
    public int DFS(int [][] matrix, int start, int end, Integer[][] dp) {
        if(start < 0 || start >= matrix.length || end < 0 || end >= matrix[0].length) {
            return 101;
        }
        else if(dp[start][end] != null) {
            return dp[start][end];
        }
        else if(start == matrix.length - 1) {
            return matrix[start][end];
        }
        return dp[start][end] = matrix[start][end] + Math.min(DFS(matrix, start + 1, end - 1, dp), Math.min(DFS(matrix, start + 1, end, dp), DFS(matrix, start + 1, end + 1, dp)));
    }
}
