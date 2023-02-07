/*
DELETE and EARN
time: O(n+max(nums))
space: O(max(nums))
 */
public class Problem1 {

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max = nums[i];
        }

        int[] dp = new int[max+1];

        for(int i=0;i<nums.length;i++){
            dp[nums[i]] = dp[nums[i]]+nums[i];
        }

        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+dp[i]);
        }

        return dp[dp.length-1];
    }
}
