# // Time Complexity : O(n + m) m-> max value in the array
# // Space Complexity : O(m) m-> max value in the array
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :
from typing import List
def deleteAndEarn(nums: List[int]) -> int:
    maxValue = max(nums)
    dp = [0] * (maxValue+1)
    
    for n in nums:
        dp[n] += n    
        
        
    skip = 0
    take = dp[0]
    
    for i in range(1, maxValue + 1):
        temp = skip
        skip = max(skip, take)
        take = dp[i] + temp
    
    return max(skip, take)

nums = [2,2,3,3,3,4]

print(deleteAndEarn(nums))
