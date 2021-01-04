# Time Complexity : O(N) 
# Space Complexity : O(N) where N is the max element of nums + 1
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        """
        notice if i take nums[i], can take all its copies and can't take any copies of num[i-1] and nums[i+1]
        
        - Can create an dpArr of N elements where N is max element of numsArr.
            - dpArr will have have values/copies of num at the i'th value
        - can do house robber on DP arr at this point
        """
        if not nums:
            return 0
        
        maxCol = max(nums)
        
        dp = [0 for i in range(maxCol+1)]
        
        for num in nums:
            dp[num] += num
        
        return self.rob(dp)
        
    def rob(self, dp):
        prev = 0 
        curr = 0
        
        for i in range(1, len(dp)):
            temp = max(prev + dp[i], curr)
            prev = curr
            curr = temp
            
        return curr
        

# Input: nums = [3, 4, 2]
# Output: 6
# Explanation: 
# Delete 4 to earn 4 points, consequently 3 is also deleted.
# Then, delete 2 to earn 2 points. 6 total points are earned.