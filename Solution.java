// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing (Solved after lecture)


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //Edge cases
        if(nums.length == 0){
            return 0;
        }
        
        int max_element = -1;
        // Creating array of size max length in nums
        for(int i=0; i< nums.length;i++){
            if(nums[i]>max_element){
                max_element = nums[i];
            }
        }
        
        int[] ar = new int[max_element+1];
        
        
        //filling the array with points

        for(int i=0; i<nums.length;i++){
            ar[nums[i]] = ar[nums[i]]+nums[i];
        }

        // final points
        
        int skip = 0;
        int take = ar[0];
        int skip_copy = skip;

        for(int i=1; i< ar.length;i++){
            
            skip_copy=skip;
            skip = Math.max(skip_copy,take);
            take = skip_copy+ar[i];
        }
        
        return Math.max(skip, take);
    }
}
