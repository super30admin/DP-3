/**
LeetCode Submitted : NA (Recursion Method)
Time Complexity : O(2^N)
Space Complexity : O(2^N)
Concept : To look for decision to to either choose current problem or not choose current problem.
Any issues : I think the main issue sfor me here was to handle cloning of the array which took some time to figure out
**/


class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        
        return Math.max(decision(nums,0,max),decision(nums,1,max));
        
    }
    
    public int decision(int[] nums, int i, int max){
        
        int[] temp = nums.clone();
        int temp_max = max;
        
        
        while(i < nums.length && nums[i] == 0){
            i++;
        }
        
        if(i == nums.length)
            return max;
        
        for(int j= i; j< nums.length;j++){
            if((nums[j] == nums[i] + 1) || (nums[j] == nums[i] - 1)){
                max = max + nums[j];
                nums[j] = 0;
            }
        }
        
        return (Math.max(decision(nums,i+1,max),decision(temp,i+1,temp_max)));
