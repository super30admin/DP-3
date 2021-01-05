// https://leetcode.com/problems/delete-and-earn/
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
class Solution {
    public int deleteAndEarn(int[] nums) {
        int dp[] = new int[10001];
        int freq[] = new int[10001];
        for(int e : nums)
            freq[e]++;
    
        int max = 0;
        for(int i=1;i<freq.length;i++){
            int frq = freq[i];
            if(frq > 0){
                dp[i] = Math.max(dp[i-1],dp[Math.max(0,i-2)]+(i*frq));
                max = Math.max(max,dp[i]);
            }else{
                dp[i] = dp[i-1];
            }
        }
        return max;
    }
}