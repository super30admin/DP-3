// Time Complexity: O(n) + O(max(n))
// Space Complexity: O(max(n))
//    - For frequency array and DP array of size (max + 1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - DP with array used
// - First, count the total sum for each unique number (number * frequency) and store it in an array `arr`.
// - Then use dynamic programming to decide whether to pick the current number (which means adding arr[i] + dp[i-2])
//   or skip it (dp[i-1]).
// - This works because picking a number means you cannot pick its immediate neighbors (i-1 and i+1).
// - Initialize dp[0] = arr[0] and dp[1] = arr[1].
// - Fill dp from index 2 to max number by comparing:
//      dp[i] = max(dp[i-1], arr[i] + dp[i-2])
// - Return dp[max] as the maximum points achievable.

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        //Loop to find the max value in the array
        int max = 0;
        for(int num : nums){
            max = Math.max(max,num);
        }

        //Create the frequency array
        int[] arr = new int[max+1];
        //Find the frequiencies
        for(int num : nums){
            arr[num] += num;
        }

        //Create the dp array
        int[] dp = new int[max+1];
        //Populate the dp array
        dp[0] = arr[0];
        dp[1] = arr[1];
        for(int i=2; i<=max; i++){
            dp[i] = Math.max(dp[i-1],arr[i]+dp[i-2]);
        }

        return dp[max];
    }
}