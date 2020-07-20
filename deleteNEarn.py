# Leetcode 740. Delete and Earn

# Time Complexity :  O(n) where n is the largest number of the array 
# Space Complexity : O(n) 

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Create a value array that holds the values of the nums array in a sorted order and has 0
# in other places. Populate the no case using the maximum value of previous row and yes case using the
# sum of current value and the no case of the previous row. Return the max of last row.

# Your code here along with comments explaining your approach

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        val=[0]*(max(nums)+1)
        
        for num in nums:
            val[num] += num 
        
        dp = [[0,0] for i in range(len(val))]
        
        for i in range(len(dp)):
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            
            dp[i][1]= val[i]+dp[i-1][0]
            
        return max(dp[len(dp)-1][0],dp[len(dp)-1][1])