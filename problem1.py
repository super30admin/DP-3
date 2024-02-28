# Time Complexity : O(n), where n is the amount and m is the number of coins. 
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :yes

from ast import List
from collections import Counter


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        counter = Counter(nums)
        max_num = max(nums)
        
        
        dp = [0] * (max_num + 1)
        
        dp[1] = counter[1] * 1
        
        for num in range(2, max_num + 1):
            dp[num] = max(dp[num - 1], dp[num - 2] + counter[num] * num)
        
        return dp[max_num]