//time-O(max(nums.length, maxNumber in nums))
//space-O(maxNumber in nums)
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int maxNum = Integer.MIN_VALUE;
        for(int n : nums){
            maxNum = Math.max(maxNum, n);
        }

        int[] dp = new int[maxNum+1];

        for(int n : nums){
            dp[n]+=n;
        }

        int skip = 0, take = 0;

        for(int n : dp){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + n;
        }

        return Math.max(skip, take);
    }
}