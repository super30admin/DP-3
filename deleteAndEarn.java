// Time Complexity : O(mn) where n is the nums array length and m is the max element in nums array
// Space Complexity : O(m) m is the maximum value of element in array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums==null || nums.length==0) return 0;
        
        int max = 0;
        int skip=0, take=0;
        
        for(int num : nums){
            max = Math.max(num,max);
        }
        
        System.out.println(max);
        
        int[] dp = new int[max+1];
        for(int num : nums){
            dp[num] +=num;
        }
        
        for(int i=1;i < dp.length;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + dp[i];
        }
        
        return Math.max(skip,take);
    }
}