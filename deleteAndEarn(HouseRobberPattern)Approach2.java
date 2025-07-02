// Time Complexity : O(n)
// Space Complexity : O(max element) -> arr is being created based on the maximum element in the given array, O(1) for two variables skip and take.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
    //None

// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //base case
        if(nums == null || nums.length == 0){
            return 0;
        }

        //find max element
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int[] arr = new int[max + 1];
        //initialValue
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] = arr[nums[i]] + nums[i];
        }
        
        int skip = 0;
        int take = 0;

        //staring from first index
        for(int i = 1; i < arr.length; i++){
            int tempSkip = skip;
            skip = Math.max(skip, take);
            take = tempSkip + arr[i];
        }

        //returning the maximum between skip and take
        return Math.max(skip, take);


    }
}