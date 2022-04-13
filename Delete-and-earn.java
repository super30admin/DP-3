// Solution - 1
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            max = Math.max(i, max);
        }
        int[] arr = new int[max + 1];
        for(int i=0;i<nums.length;i++){
            arr[nums[i]] +=  nums[i];
        }
        int[][] dp = new int[max + 1][2];
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = dp[i-1][0] + arr[i];
        }
        return Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
    }
}


// Solution - 2
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i : nums){
            max = Math.max(max, i);
        }
        int[] dp = new int[max + 1];
        for(int i : nums){
            dp[i] = dp[i] + i;
        }
        int skip = 0;
        int take = dp[0];
        for(int i=1;i<dp.length;i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);
    }
}

// Time Complexity : O(Math.max(n, maxCount))
// Space Complexity : O(maxCount)