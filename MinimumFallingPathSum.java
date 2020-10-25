/**
 * TC: O(n^2) SC: O(k), k = num of cols in grid, without changing the given grid
 * Approach : Find the min between the prev values and curr values sum, update curr sum at curr index in the dp array
 *            go through the dp to find min at the end 
 */
class Solution {
    public int minFallingPathSum(int[][] A) {
        if(A[0].length == 0) return 0;
        int n = A[0].length;
        int[] dp = new int[n];
        // initialize the dp array with the 1st  row's values
        for(int i= 0 ; i < n; i++){
            dp[i] = A[0][i];
        }
        //update the values for the dp array by maintaining the minsum at given index in dp array 
        for(int row = 1; row < n; row++){
                int[] temp = new int[n];
                for(int i = 0; i < n; i++){
                    temp[i] = dp[i];
                }
                
                for(int i = 0; i < dp.length; i++){
                    if(i == 0){
                        dp[i] = Math.min(temp[i] + A[row][i],temp[i+1]+ A[row][i]);
                    }
                    if(i > 0 && i < dp.length -1){
                        dp[i] = Math.min(temp[i-1] + A[row][i],Math.min(temp[i+1]+ A[row][i],temp[i] + A[row][i]));
                    }
                    if(i == dp.length -1){
                        dp[i] = Math.min(temp[i] + A[row][i],temp[i-1]+ A[row][i]); 
                    }
                    // System.out.println(dp[i]);
                }
        }
        //find the min from dp
        int res = Integer.MAX_VALUE;
        for(int x: dp) {
            res = Math.min(res,x);
            // System.out.println(x);
        }   
        return res;
    }
}