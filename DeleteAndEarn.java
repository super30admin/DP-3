// Time Complexity : O(N) where N is the length of the max
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int max = 0;
       
        for(int i=0; i<nums.length; i++){   
            max = Math.max(max,  nums[i]); 
        }
        
        int[] store = new int[max+1];
        
        for(int i=0; i<nums.length; i++){
            store[nums[i]] += nums[i];
        }
        
        int skip = 0;
        int take = 0;
        
        for(int i=0; i<store.length; i++){
            int t1 = skip;
            int t2 = take;
            take = store[i] + t1;
            skip = Math.max(t1,t2);
        }
        
        return Math.max(skip,take);
    }
}
