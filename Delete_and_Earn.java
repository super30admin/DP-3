// 740. Delete and Earn - https://leetcode.com/problems/delete-and-earn/
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int max = Integer.MIN_VALUE;
        
        // update max
        for(int num : nums)
        {
            if(max<num)
                max=num;
        }
        
        // max+1
        int[] arr = new int[max+1];
        
        for(int num : nums)
        {
            arr[num] += num;
        }
        
        int skip = 0, choose = arr[0];
        for(int i=0;i<arr.length;i++)
        {
            int prevSkip = skip;
            skip = Math.max(skip,choose);
            choose = prevSkip + arr[i];
        }
        return Math.max(skip,choose);
    }
}