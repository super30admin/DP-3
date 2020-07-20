// Time Complexity : O(N+Max(nums)+Max(nums)) => O(Max(nums)),  N is size of nums array
// Space Complexity : O(Max(nums)+ 2*Max(nums)) => O(Max(nums)) where Max(nums) is the maximum value in nums array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Here if we earn a value we must delete its numerical neighbor value, value -1 and value+1. The best way to find the
// numeric neighbors is keep temporary array storing the values from 0 to max(nums). So the values will act as indices.
// Then using DP approach, we can make choice to earn particular value or not. If we not earn the current value(i), we can
// store the maximum of earning or not earning the previous value(i-1). If I do earn the current value, I cannot earn the
// previous value and will need to delete it. At the end, I return the max of earning or not earning the max value.

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[][] memo = new int[max + 1][2];

        int pointsEarned[] = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            pointsEarned[nums[i]] += nums[i];
        }

        for (int i = 1; i < memo.length; i++) {
            memo[i][0] = Math.max(memo[i - 1][0], memo[i - 1][1]);
            memo[i][1] = memo[i - 1][0] + pointsEarned[i];
        }

        return Math.max(memo[max][0], memo[max][1]);
    }
}
