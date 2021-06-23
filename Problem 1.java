// Time Complexity : O(N)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this : not confident about DP, will need to review for future


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null) return 0;
        
        //find max value
        int max = 0;
        for(int num : nums){
            max = Math.max(num, max);
        }
        
        int [] sum = new int[max+1];
        
        for(int i = 0; i < nums.length; i++){
            sum[nums[i]] = sum[nums[i]] + nums[i];
        }
        
        int [][] dp = new int[sum.length][2];
        dp[0][1] = sum[0];
        for(int i = 1; i < sum.length; i++){
            //0
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            //1
            dp[i][1] = dp[i-1][0] + sum[i];
        }
        
        
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);

    }
}
