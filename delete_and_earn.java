// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max+1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]]= arr[nums[i]] + nums[i];
        }
        int[] dp = new int[arr.length];
        dp[0]=arr[0];
        dp[1]=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+arr[i]);
        }
        return dp[arr.length-1];
    }
}