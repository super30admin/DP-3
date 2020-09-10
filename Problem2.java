Time Complexity: O(n^2). n is length of matrix A.
Space Complexity: Constant
Ran successfully on leetcode?: yes

class Solution {
    public int minFallingPathSum(int[][] A) {
        int ans = Integer.MAX_VALUE;
        int n = A.length;
        int[][] dp = new int[n + 1][n];
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j + 1]);
                } else if(j == n - 1){
                    A[i][j] += Math.min(A[i - 1][j], A[i - 1][j - 1]);
                } else {
                    A[i][j] += Math.min(A[i - 1][j], Math.min(A[i - 1][j - 1],A[i - 1][j + 1]));
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            ans = Math.min(ans, A[n - 1][i]);
        }
        
        return ans;
    }
}
