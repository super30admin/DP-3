// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution1 {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        // Create an array from 0 to MAX + 1 to store sum of points
        // where MAX is the maximum value in given nums
        
        // Get MAX for the input array
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        // Create an array
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }
        
        // Use the skip or take pattern similar to the one used in House Robber Problem
        int skip = 0, take = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        
        return Math.max(skip, take);
    }
}