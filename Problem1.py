#Time Complexity : O(n)
#Space Complexity : O(n)
#Any problem you faced while coding this : none

#Your code here along with comments explaining your approach

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_val = 0
        for num in nums:
            max_val = max(max_val, num) # find the max value
        val_earned= [0] * (max_val + 1) # define an array of size being the max value to store the value obtained from each
        for num in nums:                # value obtained from each is stored
            val_earned[num] += num
        
        dp = [0] * (max_val + 1)        
        dp[0] = val_earned[0]          # if only one val then that is the value earned
        dp[1] = max(val_earned[0], val_earned[1])  # if two then the max is the value earned 
        for i in range(2, max_val + 1):
            dp[i] = max(dp[i - 1], val_earned[i] + dp[i - 2])  # consider the max among choose and no choose case 

        return dp[max_val]   # return the final value 