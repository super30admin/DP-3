// Time Complexity : O(n) + O(max(n))
// Space Complexity :  O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        // check if array is nul or empty
        if(nums == null || nums.length == 0) return 0;
        
        // initialize max value
        int max = 0;
        
        // find maximum in the nums array
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        // create new array of length max + 1
        int [] arr = new int[max + 1];
        
        // fill the array with total values (points) present in the nums array
        // corresponsing to each index
        
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += nums[i];
        }
        
        
        //house robber (can't take adjacent numbers and maximize the earnings)
        
         // initialize skip and take variables
        int skip = 0;
        int take = 0;
        
        // iterate through the array to find the maximum points
        for(int i = 1; i < arr.length; i++){
            int temp = skip;
            
            // if an element is skipped, total value until we skip the element would be
            // max of skip or take of the previous element
            skip = Math.max(skip, take);
            
            
            // if an element is chosen, total value until we choose the element would be
            // previous skip plus the value(points) corresponding to that element
            take = temp + arr[i];
            
        }
        
        // return the max value between skip and take at the end
        return Math.max(skip, take);
    }
}