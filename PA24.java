//Leetcode 740. Delete and Earn
//Time complexity : O(2p)+O(k) == O(n) // p is no of elements in original array 'nums' while k is the max element in nums
//Space Complexity : O(k) == O(n)  //k is the max element in nums
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int i=0; i<nums.length; i++){
            if(max<nums[i]){
                max=nums[i];
            }
        }
        int[] dp = new int[max+1];
         for(int i=0; i<nums.length; i++){
             dp[nums[i]]= dp[nums[i]]+nums[i];
         }
        for(int j=2; j<dp.length; j++){
            dp[j]=Math.max(dp[j-1] , (dp[j-2]+dp[j]));
        
        }
        return dp[max];
    }
}