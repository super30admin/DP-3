"""
You are given an integer array nums. You want to maximize the number of points 
you get by performing the following operation any number of times:

Pick any nums[i] and delete it to earn nums[i] points. Afterwards, 
you must delete every element equal to nums[i] - 1 and 
every element equal to nums[i] + 1.
Return the maximum number of points you can earn 
by applying the above operation some number of times.

"""

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        # O(n)
        if nums == None:
            return 0
        
        max1 = 0

        # O(n)
        for i in range(len(nums)):
            max1 = max(max1, nums[i])
            
        arr = [0 for i in range(max1+1)]
        
        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
            
        skip = take = 0
        
        # O(max(n))
        for i in range(len(arr)):
            temp = skip
            skip = max(skip, take)
            take = temp + arr[i]
            
        return max(skip, take)