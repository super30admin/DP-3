//Time complexity:O(n)+O(max)
//Space complexity:O(max)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int[] dp=new int[max+1];
        for(int i:nums){
            dp[i]+=i;
        }
        
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+dp[i]);
        }
        return dp[max];
    }
}