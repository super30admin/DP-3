// Time Complexity : O(Max(nums.length, max value present in nums))
// Space Complexity : O(max value present in nums)
// Did this code successfully run on Leetcode :yes
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max = nums[0];
        
        for(int i=1; i< nums.length; i++){
            max  = Math.max(max, nums[i]);
        }
        
        int [] arr = new int[max+1];
        
        for(int i=0; i<nums.length; i++){
            int index = nums[i];
            arr[index] += nums[i];  
        }
        
        
        int leave=0; int take=arr[0];
        
        
        for(int i=1; i<arr.length; i++){
            int prevLeave = leave;
            
            leave = Math.max(prevLeave,take);
            take = prevLeave + arr[i];
            
        }
        
        return Math.max(leave,take);
        
    }
}