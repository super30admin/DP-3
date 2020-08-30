# 740. Delete and Earn

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
         # Base cases
            
        if len(nums)==1:
            return nums[0]
        if not nums:
            return 0
        
        res = [0 for i in range(max(nums)+1)]
        
        # Initializing the variables
        
        ch = 0
        dch = 0
        prevch = 0
        prevdch = 0
        
        # At each index we add the values from given array
        # into the array we created.
        for i in nums:
            res[i] += i
        
        # Same as House robber logic.
        for i in range(1,len(res)+1):
            prevch = ch
            prevdch = dch
            ch = prevdch + res[i-1]
            dch = max(prevch, prevdch)
            
        
        return max(ch,dch)
        
# Time Complexity: O(N)
# Space Complexity: O(N) -> N will be max 10001.
# Accepted on Leetcode: Yes.
# Any Difficulty faced. No.