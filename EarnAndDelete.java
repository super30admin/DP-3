// Time Complexity : O(Max(O(nums),O(arr))
// Space Complexity : O(arr)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        int skip = 0;
        int take = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max) max = nums[i];
        }
        int [] arr = new int [max + 1];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] = nums[i] + arr[nums[i]];
        }
        for(int i = 0; i < arr.length; i++){
            int temp = skip;
            skip = Math.max(temp, take);
            take = temp + arr[i];
        }
        return Math.max(skip,take);
    }
}