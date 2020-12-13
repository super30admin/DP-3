# https://leetcode.com/problems/delete-and-earn/submissions/
# Approach: Dynamic programming
# What we have done here is we made a new array from given array using this logic. Any index i in new array will contain the sum of all the ith values present in the given array. For example in the given array there are three 2's. Then 2nd index of new array will contain 2*3 as a value.

# By doing this we have converted our problem to a house robber problem where we want the maximum value such that we are not allowed to use the value of two adjacent indices.

# Time complexity: O(max(n,2m)) where n = length of the given array, m is the maximum of number found in the given array
# Space complexity: O(m) where m = maximum of number found in the given array
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        maxi = max(nums)

        amounts = [0] * (maxi + 1)
        
        for num in nums:
            amounts[num] += num
        
        print(amounts)
        
        dp = [0] * len(amounts)
        dp[0] = amounts[0]
        dp[1] = max(amounts[0], amounts[1])
        
        for i in range(2, len(dp)):
            dp[i] = max(dp[i-2] + amounts[i], dp[i-1])
            
        return dp[-1]
        
        
        
        