// Time Complexity : O(Max(n,m)), n = maximum value of nums array, m = length of nums array
// Space Complexity : O(n), n = maximum value of nums array
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for(int x : nums)
            max = Math.max(max, x);
        int[] arr = new int[max+1];
        for(int num : nums) 
            arr[num] += num; 
        
        int skip = 0, choose = arr[0];
        for(int i=0; i< arr.length; i++) {
            int prevSkip = skip;
            skip = Math.max(skip, choose);
            choose = prevSkip + arr[i];
        }
        return Math.max(skip, choose);
    }
}