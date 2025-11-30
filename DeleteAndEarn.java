// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++)
        {
            max = Math.max(nums[i], max);
        }
        int[] sumarray = new int[max+1];
        for(int i = 0; i < nums.length; i++)
        {
            sumarray[nums[i]] += nums[i];
        }

        int prev = sumarray[0];
        int curr = Math.max(sumarray[0], sumarray[1]);
        for(int i = 2; i <= max; i++)
        {
            int temp = Math.max(curr, prev+sumarray[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
