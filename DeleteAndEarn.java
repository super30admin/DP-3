//https://leetcode.com/problems/delete-and-earn/
/*
 Time: O(n) where n=nums.length
Space: O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None

*/
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int[] points = new int[10001]; // 1 <= nums[i] <= 10^4

        for (int num : nums)
            points[num] += num;

        int[] dp = new int[10001];

        dp[0] = points[0];
        dp[1] = points[1];

        for (int i = 2; i < points.length; i++)
            dp[i] = Math.max(points[i] + dp[i - 2], dp[i - 1]); // house robber logic

        return dp[10000];
    }

}
