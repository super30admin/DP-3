class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxNums = 0;
        for(int i = 0; i < nums.length; i++){
            maxNums = Math.max(maxNums, nums[i]);
        }
        int[] nums2 = new int[maxNums+1];
        int[][] dp = new int[maxNums+1][2];
        for(int i : nums){
            nums2[i] += i;
        }
        for(int i = 1; i < maxNums+1; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = nums2[i] + dp[i-1][0];
        }   
        return Math.max(dp[maxNums][0], dp[maxNums][1]);
    }
}
