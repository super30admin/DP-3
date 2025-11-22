# Time Complexity :O(max_val)+O(n)
# Space Complexity :O(max_val)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :No


# Your code here along with comments explaining your approach
# Build array_p where array_p[i] = total points from all is in nums.
#Use DP with dp[i] = max(dp[i-1], dp[i-2] + array_p[i]) to choose between taking or skipping each number
# Return dp[max_val] as the maximum points you can earn.

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        max_val = max(nums)
        array_p = [0]*(max_val+1)
        dp =  [0]*(max_val+1)
        for i in nums:
            array_p[i] += i
        dp[0] = 0
        dp[1] = array_p[1]
        for i in range(2,len(array_p)):
            dp[i] = max(dp[i-1],array_p[i]+dp[i-2])
        return dp[-1]
        
        