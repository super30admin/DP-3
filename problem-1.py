"""
Approach

1. To find the maximum amount, we can begin with either choosing the first elemnt or not choosing the first element. However, we dont not have optimal solution for the nemerical neighbours.
2. To make the numerical neighbours available before we calculate the next maximum amount, we can create a dp matrix with row header representing the amounts 
0 to Max(nums)+1
3. the maximum amount that can be collected will be equal to max of the last row from the dp matrix

"""


# Time Complexity : O(M) where M is max(nums)
# Space Complexity : O(M) where M is max(nums)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums==None or len(nums)==0:
            return 0
        
        maxNumber = max(nums)
        possibleEarning = [0] * (maxNumber+1)
        
        # set the dp problem as house robbing
        for num in nums:
            possibleEarning[num] = possibleEarning[num]+ num
        
        dp = [[0 for j in range(2)]for i in range(maxNumber+1)]
        
        for i in range (1,maxNumber+1):
            for j in range (1,2):
                dp[i][0] = max(dp[i-1][0],dp[i-1][1])
                dp[i][1] = possibleEarning[i] + dp[i-1][0]
        
        return max (dp[maxNumber])
                