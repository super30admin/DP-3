// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        // brute force
        return helper(nums, 0, 0, 0, 0);
    }
    
    private int helper(int[] nums, int i, int profit, int ignore1, int ignore2){
        if(i >= nums.length){
            return profit;
        }
        //base
        if( i < nums.length && nums[i] == ignore1){
            return 0;
            // i = i+1;
        }
        if( i < nums.length && nums[i] == ignore2){
            return 0;
            
             // i = i+1 ;
        }
        // ignore 1 and 2 is the numbers that are not going to be a part of the decision
        //case1
        int reject = helper(nums, i+1, profit, ignore1, ignore2); 
        //case2
        int accept = helper(nums, i+1, profit + nums[i], nums[i]-1, nums[i]+1);
        //result
        
        return Math.max(reject, accept);
        
    }
}
