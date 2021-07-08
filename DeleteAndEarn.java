// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
    no 

// Your code here along with comments explaining your approach


class Solution {
    public int deleteAndEarn(int[] nums) {
        
        
        if(nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
    
        for(int i=0;i<nums.length;i++){
           
            max = Math.max(nums[i],max);
        }
        int[] a = new int[max+1];
        for(int i = 0;i<nums.length;i++){
            
            a[nums[i]]+=nums[i];
        }
        

        int take = a[0];
        int skip = 0;
        
        for( int i=1;i<a.length;i++){
             int temp = skip;
			 //skip a element
             skip =  Math.max(skip,take);
             //take a element
			 take = temp+a[i];
        }
        
        return Math.max(skip,take);
    }
}