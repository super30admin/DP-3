// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int[] modifiedarray = new int[getMax(nums)+1];
        
        for(int i=0;i<nums.length;i++){
            
            modifiedarray[nums[i]]+=nums[i];
            
        }
        
         int c =0;
         int dc=0;
        
        for(int i=0;i<modifiedarray.length;i++){
           
            int temp=dc;
            dc = Math.max(c,dc);
            c= temp+ modifiedarray[i];
        }
        
        return Integer.max(c,dc);
    }
    public int getMax(int[] nums){
        int max= Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max;
    }
}
