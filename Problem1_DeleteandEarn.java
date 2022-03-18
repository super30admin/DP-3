// Time Complexity : O(N) + O(Maximum element of array)
// Space Complexity : O(Maximum element of array)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach


class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)    return -1;
        
        int len = max(nums);
        int[] dp = new int[len + 1];
        
        for(int i = 0; i< nums.length; i++){
            dp[nums[i]] += nums[i];
        }

        int choose = 0, avoid = dp[0];
        
       for(int i = 1; i< dp.length; i++){
           int curr = avoid; // avoid is PREVIOUS case -- Don't Choose case value
           //Choose is Previous case chosen-value
           avoid = Math.max(choose, avoid);
           choose = dp[i] + curr;
           
       }
        
       return Math.max(choose, avoid);


        // int[][] ans = new int[dp.length][2];
        // //Using HouseRobber technique on dp[] array

        // ans[0][0] = 0;
        // ans[0][1] = dp[0];
        // for(int i = 1; i< ans.length; i++){
        //     ans[i][0] = Math.max(ans[i-1][0], ans[i-1][1]);
        //     ans[i][1] = dp[i] + ans[i-1][0];
        // }

        // return Math.max(ans[ans.length - 1][0], ans[ans.length - 1][1]);
    }
    public int max(int[] nums){
        int max = nums[0];
        for(int i = 1; i< nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}