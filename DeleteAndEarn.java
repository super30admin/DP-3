// Time Complexity : O(max_num) where max_num is the largest number in nums
// Space Complexity : O(max_num)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to ensure max was calculated correctly and understood mapping to House Robber problem

// Your code here along with comments explaining your approach

class DeleteAndEarn
{
    public int deleteAndEarn(int[] nums)
    {
       // Step 1: Find min and max in nums
       // min is not strictly necessary for this array-based approach, but max is needed
       int min = Integer.MAX_VALUE;
       int max = 0;
       for(int num : nums)
       {
           min = Math.min(min, num);
           max = Math.max(max, num); // fixed to find correct max
       }
       
       // Step 2: Build an array where arr[i] stores the total points 
       // gained if we take all occurrences of i
       int[] arr = new int[max + 1];
       for(int num : nums)
       {
           arr[num] += num;
       }
       
       // Step 3: Apply House Robber DP logic
       // dp[i] represents max points from numbers 0 to i
       int[] dp = new int[max + 1];
       dp[0] = arr[0];
       dp[1] = Math.max(arr[0], arr[1]);
       
       for(int i = 2; i <= max; i++)
       {
           // Either skip current number (dp[i-1])
           // Or take current number and add dp[i-2]
           dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
       }
       
       return dp[max];
    }
}
