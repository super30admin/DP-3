
// Time Complexity : Add : O(N log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {2,2,3,3,3,4};
        deleteAndEarn(nums);
    }

    public static int deleteAndEarn(int[] nums) {
        if(nums==null) return 0;

        Arrays.sort(nums);

        int max=nums[nums.length-1];

        int[] dp = new int[max+1];
        int result = 0;

        // Add the value for each index
        for(int num : nums){
            dp[num] += num;
        }

        int skip = 0;
        int take = dp[0];

        for(int i=1; i<dp.length; i++){
            int temp = skip;
            //Maintain the maximum value
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }

        return Math.max(skip, take);
    }
}


