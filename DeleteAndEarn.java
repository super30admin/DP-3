// Time Complexity : O(n + max(nums[i]))
// Space Complexity : O(max(nums[i]))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// We create a hashmap using nums where the mapping is nums[i]-> nums[i]*frequency
// We need to have an entry for all numbers from 1 to max(nums[i])
// Once we have this mapping, this is similar to House Robber problem and can be solved using DP

class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++)
            if(nums[i]>max)
                max = nums[i];
        int[] arr = new int[max+1];
        for(int i=0;i<n;i++)
            arr[nums[i]]+=nums[i];

        int prev = arr[0];
        int cur = Math.max(arr[0],arr[1]);

        for(int i=2;i<max+1;i++)
        {
            int newCur = Math.max(prev+arr[i],cur);
            prev = cur;
            cur = newCur;
        }
        return cur;
    }
}