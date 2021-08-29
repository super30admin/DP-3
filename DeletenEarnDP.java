// Time Complexity :Max(Largest element , lengthofArray)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int minNoOfCoins = -1;
        // null case
        if(coins.length ==0 || coins == null)
            return minNoOfCoins;
        
       int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 0;
        for(int i =1 ; i< dp[0].length;i++)
        {
            dp[0][i] = amount+1;
        }
        for(int r =1 ; r< dp.length;r++)
        {
            for(int c = 0 ; c < dp[0].length; c++)
            {
                // case1 = amount is lesser than coin value
                if(c<coins[r-1])
                {
                  dp[r][c] = dp[r-1][c];
                } 
                else
                {
                    // case2 amount is equal or greater than coin value
                 dp[r][c] = Math.min(dp[r-1][c],1+dp[r][c-coins[r-1]]);
                                     
                 }
            }
        }
        
        int result = dp[dp.length-1][dp[0].length-1 ];
        if(result > amount)
            return -1;
        else return result;
    }
  
}