# Time Complexity : O(N+max(n))
# Space Complexity : O(max(n))  
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
#I find the maximum value in the input array to determine the size of the auxiliaryarray. 
# Then, I create an array where each index represents the total points that can be earned by taking that number. Finally, I an approach similar to the "House Robber"
# problem to calculate the maximum points that can be earned without taking adjacent numbers.

from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxy = 0
        for i in nums:
            maxy = max(maxy,i)
        arr = [0] * (maxy+1)
        for i in nums:
            arr[i] += i
        dp = [0] * (maxy + 1)
        dp[0] = arr[0]
        dp[1] = max(arr[0],arr[1])
        for i in range(2,maxy+1):
            dp[i] = max(dp[i-1],arr[i] + dp[i-2])        
        return dp[maxy]

        