// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[maxNum(nums) + 1];
        
        for(int i=0; i<nums.length; i++){
            dp[nums[i]] += nums[i];
        }
        
        int C = 0, DC = 0;
        int temp = -1;
        
        for(int i : dp){
            temp = C;
            C = i + DC;
            DC = Math.max(temp, DC);
        }
        return Math.max(C, DC);
    }
    
    private static int maxNum(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}