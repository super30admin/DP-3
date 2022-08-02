class Solution {
    /*
     * Time Complexity - O(n + max(n)) where n is the number of elements
     * Space Complexity - O(max(n))
     */
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            if (max<nums[i])
                max = nums[i];
        }
        // For each num, add it to array at index i=num
        int[] sumi = new int[max+1];
        for (int i=0; i<nums.length; i++) {
            sumi[nums[i]] += nums[i];
        }
        int[] dp = new int[sumi.length];
        dp[1] = sumi[1];
        for (int i=2; i<sumi.length; i++) {
            // Find the max between not choose & choose
            dp[i] = Math.max(dp[i-1], sumi[i] + dp[i-2]);
        }
        return dp[sumi.length-1];
    }
}