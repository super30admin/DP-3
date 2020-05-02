
class Solution {

    // Time Complexity : O(N)
    // Space Complexity : O(1) constant space of 10001 size array
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Finding the solution on my own


    // Delete and earn
    /**
     * 1. In this question we have to neglect the a number less and greater than given number in array
     * 2. successively calculate the sum of number less than two and save the maximum value in current position.
     */
    public int deleteAndEarn(int[] nums) {
        
        int[] arr = new int[10001];
        for(int n : nums) {
            arr[n] += n;
        }
        
        int dp[] = new int[10001];
        dp[0] = arr[0];
        dp[1] = arr[1];
        
        for(int i=2; i<dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + arr[i], dp[i-1]);
        }
        
        return dp[10000];
        
    }

    // Time Complexity : O(N^2)
    // Space Complexity : O(1) 
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Finding the solution on my own


    // Minimum falling path sum
    /**
     * 1. find smallest element in first row and add that minimum value to the elements of next row.
     * 2. Repeat the process till last row.
     * 3. Find minimum element from last row.
     */
    public int minFallingPathSum(int[][] A) {
        
        for(int i=1; i<A.length; i++) {
            for(int j=0; j<A.length; j++) {
                A[i][j] += Math.min(A[i-1][j], Math.min(A[i-1][Math.max(0, j-1)], A[i-1][Math.min(A.length-1, j+1)]));
            }
        }
        
        int ans = Integer.MAX_VALUE;
            
        for(int k=0; k<A.length; k++) {
            ans = Math.min(ans, A[A.length-1][k]);
        }

        return ans;
        
    }
}