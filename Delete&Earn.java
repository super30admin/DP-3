// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        //base case to check if the array is empty
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        //update max
        for(int num: nums){
            if(max < num)
                max = num;
        }
        
        int[] arr = new int[max + 1];
        
        for(int num: nums)
            arr[num] += num;
        
        //either we chose the first value so we add it or we skip and start with 0
        int skip = 0, choose = arr[0];
        
        for(int i = 0; i < arr.length; i++){
            //temp var to hold the value of skip
            int prevSkip = skip;
            //new skip will be max of previous two values
            skip = Math.max(skip, choose);
            //if chosen, then start with previously skipped value plus the current value
            choose = prevSkip + arr[i];
        }
        
        //we want to return the max amount possible
        return Math.max(skip, choose);
    }
}