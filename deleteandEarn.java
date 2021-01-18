class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max,num);
        }
        int[] arr = new int[max +1];
        for(int num : nums){
            arr[num] += num;
        }
        int n = arr.length;
        int[][] dp = new int[n][2];
        dp[0][1] = arr[0];
        for(int i = 1; i < arr.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + arr[i];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}