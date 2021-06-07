// Time Complexity : O(Max(n,max))
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        //find the maximum
        for(int i = 0;i < nums.length;i++)
            max = Math.max(max,nums[i]);
        int arr[] = new int[max + 1];
        //caluclate total points for each value
        for(int i = 0;i < nums.length;i++){
            arr[nums[i]] += nums[i];
        }
        int take = 0;
        int skip = 0;
        //house robber pattern
        for(int i = 0; i < arr.length;i++){
            int tempSkip = skip;
            skip = Math.max(skip,take);
            take = arr[i] + tempSkip;
        }
        return Math.max(skip,take);
    }
}