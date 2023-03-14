# Time Complexity : O(n) where n : input array nums
# Space Complexity : O(n)

from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # Get the maximum number in the nums array
        max_num = max(nums)
        
        # Create a new array to store the frequency of each number in nums
        freq = [0] * (max_num+1)
        for num in nums:
            freq[num] += 1
        
        # Initialize dp array with 0s for the first two values
        dp = [0] * (max_num+1)
        dp[1] = freq[1] * 1
        
        # Iterate over the numbers and update dp array
        for i in range(2, max_num+1):
            dp[i] = max(dp[i-1], dp[i-2] + freq[i]*i)
        
        # Return the last value of dp array
        return dp[max_num]