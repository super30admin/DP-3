/*
    Time Complexity : O(n)
    Space Complexity : O(n)
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        
        int[]arr = new int[max + 1];
        for(int i=0; i<nums.length; i++){
            arr[nums[i]] += nums[i];
        }
        
        int[] dp = new int[arr.length];
        for(int i=1; i<dp.length; i++){
            int select = arr[i] + ( i-2 >= 0 ? dp[i-2] : 0);
            int notSelect = dp[i-1];
            dp[i] = Math.max(select, notSelect);
        }
        return dp[max];
    }
}
