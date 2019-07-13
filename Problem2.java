// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A == null || A.length == 0) return 0;
        int len = A.length;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int val1 = j > 0 ? A[i-1][j-1] : Integer.MAX_VALUE;
                int val2 = A[i-1][j];
                int val3 = j < A.length - 1 ? A[i-1][j+1] : Integer.MAX_VALUE;
                A[i][j] += Math.min(val1, Math.min(val2, val3));
            }
        }
        int ans = A[len-1][0];
        for (int i = 0; i < len; i++) {
            ans = Math.min(ans, A[len-1][i]);
        }
        return ans; 
    }
}
