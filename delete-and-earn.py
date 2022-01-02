# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxEl = max(nums)
        dp = [0]*(maxEl+1)
        for i in range(len(nums)):
            print(nums[i])
            dp[nums[i]] += nums[i]

        
        skip = 0
        take = 0
        for i in range(len(dp)):
            temp = skip
            skip = max(skip, take)
            take = temp + dp[i]
            
        return max(skip, take)