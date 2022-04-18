'''https://leetcode.com/problems/delete-and-earn/
'''

# Time Complexity : O(max(N, max_value in N))
# Space Complexity : O(max(max_value in N))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def deleteAndEarn(self, nums: 'list[int]') -> int:
        maxi = float('-inf')
        for n in nums:
            maxi = max(maxi, n)
        
        dp = [0 for _ in range(maxi+1)]
        
        for n in nums:
            dp[n] += n
        
        skip = 0 # val if skipped
        take = dp[0] # val if taken
        
        for i in range(1, len(dp)):
            prev_skip = skip
            skip = max(skip, take)
            take = prev_skip + dp[i]
        
        return max(skip, take)
            
        
        
            