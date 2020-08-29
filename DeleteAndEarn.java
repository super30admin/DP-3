// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Prepare to use House Robber


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        //[3, 4, 2]
        if(nums.length==0)
            return 0;
        
        int max=0;
        for(int n: nums){
            max = Math.max(max, n);
        }
        
        //count [0, 0, 0, 0, 0]
        int count[] = new int[max+1];
        for(int n: nums){
            count[n]+= n;
        }
        //count [0, 0, 2, 3, 4]
        
        // dp [0, 0, 0, 0, 0]
        // House Robber
        int dp[] = new int[max+1];
        dp[0] = 0;
        dp[1] = count[1];
        
        for(int i=2; i<=max; i++){
            dp[i] = Math.max(count[i] + dp[i-2], dp[i-1]);
        }
        return dp[max];
    }
}