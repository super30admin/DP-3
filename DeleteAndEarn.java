// TIME: O(n)
// SPACE: O(n)
// SUCCESS on LeetCode

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        
        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] += nums[i];
        }
        
        for (int i = dp.length - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i+1], dp[i+2] + dp[i]);
        }
        
        return dp[0];
    }
}
