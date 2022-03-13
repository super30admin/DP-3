
    # 740. Delete and Earn
    # Time Complexity : O(n)
    # Space Complexity : O(1)
    # Did this code successfully run on Leetcode : Yes
    # Any problem you faced while coding this : No     

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_value = max(nums)
        z= [0] * (max_value+1)
        for i in range(len(nums)):
            z[nums[i]] += nums[i]
        
        take = 0
        skip = 0
        for i in range(1, len(z)):
            p_skip = skip
            skip = max(skip, take)
            take = p_skip+z[i]
        return max(skip, take)
                
        
        