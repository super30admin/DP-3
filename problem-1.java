// Time Complexity : Max(O(n), O(max(n)))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        //Find the Maximum O(n)
        for(int i=0; i<nums.length; i++){
            max=Math.max(max, nums[i]);
        }
        int[] dp = new int[max+1];
        //Coun the occurence of each value O(n)
        for(int i=0; i<nums.length; i++){
            dp[nums[i]]++;
        }
        //If there is only 0's then max amount that can be earned is 0
        if(dp.length<2){
           return 0;
        }
        //At each element the max that can be earned is the maximum of either not choosing that element i.e dp[i-1] or the sum of choosing the curr element * num of times it occured i.e (i*dp[i]) and the max sum earned upto the curr-2nd element i.e dp[i-2]
        for(int i=2; i<dp.length; i++){
            dp[i]=Math.max(dp[i-1], (i*dp[i])+dp[i-2]);
        }
        return dp[max];
        
    }
}
