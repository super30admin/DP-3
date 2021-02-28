// Time Complexity : O(n. n), n = no. of rows or columns of matrix. since we will traverse through the entire n x n matrix
// Space Complexity : O(2n), asymptotically O(n).
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public int minFallingPathSum(int[][] A) {
      
        if(A == null || A.length == 0 || A[0].length == 0)
            return 0;
        int[] dp = new int[A[0].length];
        dp = A[0];
        
        int[] temp = new int[dp.length];
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(j == 0){
                    temp[j] = A[i][j] + Math.min(dp[j], dp[j+1]);
                }
                else if(j == (dp.length -1)){
                    temp[j] = A[i][j] + Math.min(dp[j-1], dp[j]);
                }else{
                    temp[j] = A[i][j] + Math.min(dp[j-1], Math.min(dp[j], dp[j+1]));   
                }
            }
            dp = Arrays.copyOf(temp, temp.length);
        }
        return getMin(dp);
    }
    private int getMin(int[] cost){
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < cost.length; k++){
            if(cost[k] < min){
                min = cost[k];
            }
        }
        return min;
    }
}

