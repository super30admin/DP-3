// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// We reduce the problem to house robber problam and solve using DP.
class DeleteAndEarnSolution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max+1];
        for(int num: nums) {
            dp[num] +=num;
        }
        int skip=0, take=0;
        for(int i=0; i<dp.length; i++) {
            int temp = Math.max(skip, take);
            take = skip + dp[i];
            skip = temp;
        }
        return Math.max(skip, take);
    }
}