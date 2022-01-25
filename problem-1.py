# Leetcode Excution: YES
# Time Complexity: O(max(n, maxvalue))
# Space Complexity: O(maxvalue)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # so we first loop through the nums to get the max element
        m=float('-inf')
        for x in nums:
            m=max(m,x)
          # we then create array of length maxelement +1
        dp=[0 for _ in range(m+1)]
        # we will then add the value of nums[i] to dp[nums[i]]
        for i,x in enumerate(nums):
            dp[x]+=x
            
        skip=0
        pick=0
        # this way we have converted our problem into house robber where we cannot pick adjacent numbers
        # we proces the skip and pick operation 
        # skip : in case of skip we will get th emax of previous skip and pick
        # pick: in case of pick we canot have pick of previous value so we add current pick to previous skip value
        for i,x in enumerate(dp):
            temp=skip
            skip=max(skip,pick)
            pick=temp+x
        # we then return the max of the skip and pick 
        return max(skip, pick)
        