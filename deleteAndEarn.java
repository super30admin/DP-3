//this problem is based on houseRobber one, i build solution on top of that
// first we find the max element in given array
// use technique of arr[num] + num then apply house robber logic
// Time Complexity :o(max(n, maxelement in array))
// Space Complexity :o(max element in array)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
           max = Math.max(num, max);
        }
        int[] dp = new int[max + 1];
        for(int num: nums) {
            dp[num] = dp[num] + num;
        }
        int skip = 0, take = dp[0];
        for(int i = 1; i < dp.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);
    }
}