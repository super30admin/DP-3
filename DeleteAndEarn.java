// Time Complexity : O(n + max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
Find the max value across the input array to help us understand the output array limit. Compute the sum of
each element occurence in another array and then find the max points similar to house robber problem style
by only considering previous and the one before that to understand the current value.
 */

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;

        for(int num : nums)
            max = Math.max(max, num);

        int[] countNums = new int[max + 1];

        for(int num : nums)
            countNums[num] += num;

        int prev = countNums[0];
        int curr = Math.max(prev, countNums[1]);

        for(int i = 2 ; i <= max ; i++) {
            int temp = curr;
            curr = Math.max(curr, countNums[i] + prev);
            prev = temp;
        }
        return curr;
    }
}