# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach



class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        '''Building a frequency array to convert this problem into the house robber problem'''
        
        maxVal = max(nums) 
        dp = [0] * (maxVal + 1)
        for num in nums:
            dp[num] += num
        
        '''House robber pattern on the above frequency array.'''
        prev2prev = dp[0]
        prev = dp[1]
        for i in range(2, len(dp)):
            temp = max(prev2prev + dp[i], prev)
            prev2prev = prev
            prev = temp
        
        
        return prev