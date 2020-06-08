// Time Complexity : O(n+max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Need to maintain sums of each occurrences in the array and do the rest 
// which is similar to house robber problem

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        for(int num:nums) {
            max = Math.max(max,nums[i]);
        }
        int[] arr = new int[max+1];
        for(int num : nums) {
            arr[num] = arr[num] + num;
        }
        int skip = 0; int take = 0;
        for(int i = 1; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + arr[i];
        }
        return Math.max(skip,take);
    }
}