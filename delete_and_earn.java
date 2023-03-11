import java.util.Map;
import java.util.HashMap;

// Time Complexity : O(max(n, maxNum)); n = nums.length, maxNum = maximum number in nums array
// Space Complexity : O(maxNum);  maxNum = maximum number in nums array
// Did this code successfully run on Leetcode : Yes
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max = 0;
        // Generate a frequency map to note how many times a num occured in nums
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, num);
        }

        int[] dp = new int[max+1];
        dp[0] = 0;
        dp[1] = map.getOrDefault(1, 0) * 1;

        for(int i = 2; i <= max; i++) {
            dp[i] = Math.max(
                // Choose to earn this value
                (map.getOrDefault(i, 0) * i) + dp[i-2],
                // Do not choose to earn this value
                dp[i-1]
            );
        }

        return dp[max];
    }
}