//time Complexity: O(N+k)
//spcae complexity: O(N+k)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int max = 0;
        for(int num : nums){            
            max = Math.max(max, num);
        }
        int[] val = new int[max + 1];
        for(int num : nums)
            val[num]++;
        int[] dp = new int[max + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = Math.max(dp[i - 1], (i > 1 ? dp[i - 2]: 0) + i * val[i]);
        }
        return dp[max];
    }
}