// Time Complexity : O(N) where N is the input array length
// Space Complexity :O(max(N)) largest element in input array.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

public class DeleteAndEarn
{
    class Solution {
        public int deleteAndEarn(int[] nums)
        {
            int largestNum = 0;
            for(int i = 0; i< nums.length; i++)
                largestNum = Math.max(largestNum, nums[i]);

            int[] cumulativePoints = new int[largestNum+1];

            for(int i = 0; i< nums.length; i++)
                cumulativePoints[nums[i]] = cumulativePoints[nums[i]] + nums[i];

            int[] dp = new int[cumulativePoints.length];

            dp[0] = cumulativePoints[0];
            dp[1] = cumulativePoints[0] > cumulativePoints[1] ?  cumulativePoints[0] : cumulativePoints[1] ;

            for(int i = 2; i < cumulativePoints.length; i++)
                dp[i] = Math.max(dp[i-1], cumulativePoints[i]+dp[i-2]);

            return dp[dp.length-1];
        }
    }
}
