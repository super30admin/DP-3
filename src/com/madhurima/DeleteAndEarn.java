/*
    Time Complexity = O(maximum between length of nums and maximum element in nums)
    Space Complexity = O(maximum element in nums)
    Did this code successfully run on Leetcode : yes
 */


package com.madhurima;

public class DeleteAndEarn {
}

class SolutionB {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for(int each: nums){
            max = Math.max(max, each);
        }

        int n = nums.length;
        int[] dp = new int[max + 1];

        //iterate over nums array and fill the dp array
        for(int i = 0; i < n; i++){
            int idx = nums[i];
            dp[idx] = dp[idx] + nums[i];
        }

        //same as house robber
        int skip = 0, take = dp[0];

        //iterate through dp array
        for(int i = 1; i < max+1; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }

        return Math.max(skip, take);

    }

    public static void main(String[] args) {
        SolutionB s = new SolutionB();
        int[] nums = {2,2,3,3,3,4};
        System.out.println(s.deleteAndEarn(nums));
    }
}
