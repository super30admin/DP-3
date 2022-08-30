// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: I struggled with implementation and also optimizing my solution.


// Your code here along with comments explaining your approach
class Solution {
    
    //Time complexity - O(n^2)
    //Space complexity - O(n^2)
    public int minFallingPathSum(int[][] matrix) 
    {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        //Loops through and initializes the dp first row to the matrix first row.
        for(int i = 0; i < n; i++)
        {
            dp[0][i] = matrix[0][i];
        }
      
        //Loops from the first index in the row
        for(int i = 1; i < n; i++)
        {
            //Loops from the zeroth index in the column
            for(int j = 0; j < n; j++)
            {
                
                //Checks if j is equal to zero and grab the value from the top right of the cell
                if(j == 0)
                {
                     dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j + 1]);
                }
                 //Checks if j is equal to n-1 and grab the value from the left 
                else if(j == n - 1)
                {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j - 1]);
                }
                else
                {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]);
                    dp[i][j] = Math.min(dp[i-1][j+1], dp[i][j]);
                }
                 dp[i][j] += matrix[i][j]; 
                
            }      
          
        }
        int result = Integer.MAX_VALUE;
    
        for(int nums: dp[n-1])
        {
            result = Math.min(result, nums);
        }
        return result;
    }
    
    
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: I kept getting index out of bound error.

class Solution {
    
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        int[] frequency = new int[10001];
        
        //Loops through the array and updates the frequency
        for(int i = 0; i < nums.length; i++)
        {
            frequency[nums[i]]++;
        }
        
        dp[0] = 0; //Sets the dp of the zeroeth index to zero
        dp[1] = 1 * frequency[1]; //Sets the dp of one to the frequency of one. 
        
        //Loops from the second index and sets the dp of i
        for(int i = 2; i < 10001; i++)
        {
            dp[i] = Math.max(dp[i-1],dp[i-2] + i * frequency[i]);
        }
        return dp[10000];
    }
}