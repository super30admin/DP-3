// Time Complexity : O(Max(nums length, max element in nums))
// Space Complexity : O(Max(nums length, max element in nums))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: Basically, if we pick one index, we can not pick the one right next to it. This is the same as house robber. So I used DP array and at every element I have 2 choices to include or not. If I include, I add nums[i] * its frequency in a greedy approach to include all as we are anyway deleting alternates. If exclude, I just use the previous value.

import java.util.HashMap;

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 1) return nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, n);
        }
        int [] dp = new int[max+1];
        for(int i = 1; i<dp.length; i++){
            int include = (map.containsKey(i)?map.get(i):0)*i + ((i-2)>=0?dp[i-2]:0);
            int exclude = dp[i-1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[max];
    }
}