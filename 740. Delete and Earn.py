# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Find the repeating subproblem
# create an aux array of values in its index
# iterate the aux array to find the value when taken or skipped
# return the max value at the end of the iteration

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        length = max(nums)
        
        aux = [0] * (length+1)
        
        for i in range(len(nums)):
            aux[nums[i]] += nums[i]
        skip = 0
        take = aux[0]
        for i in range(len(aux)):
            temp = skip
            skip = max(skip,take)
            take = temp + aux[i]
        return max(skip,take)
            