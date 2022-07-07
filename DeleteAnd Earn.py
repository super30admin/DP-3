#Time Complexity : O(m*n) 
#Space Complexity: O(1)
#Ran on LeetCode : YES
from collections import defaultdict
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxPointer = max(nums)
        points = [0 for _ in range(maxPointer + 1)]

        for num in nums :
            points[num] += num

        dp0 = points[0]
        dp1 = points[1]

        for i in range(2,len(points)):
            newValue = max(points[i] + dp0 , dp1)
            dp0 = dp1
            dp1 = newValue


        return max(dp1,dp1)
