// DELETE AND EARN

// Time Complexity : O(n), where n is the length of the input array nums
// Space Complexity : O(m), where m is the maximum element in the input array nums
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max)
                max = nums[i];
        }
        int[] arr = new int[max];

        for(int i = 0; i < nums.length; i++){
            arr[nums[i] - 1] += nums[i];
        }

        if(arr.length == 1)
            return arr[0];

        int[] dp = new int[max];
    
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], 0 + arr[1]);

        for(int i = 2; i < arr.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
        }
        return dp[max - 1];
    }
}