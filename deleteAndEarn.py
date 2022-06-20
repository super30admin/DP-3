"""Approach:
Reduce to house robber.
Most important thing is to recognize and put the data in the workable format.
In this case if we put it in the array of size max(nums)+1 such that
arr[n] += n for each number in nums, e.g.:
input[3, 4, 2] and workable arr [0, 0, 2, 3, 4]
input [2, 2, 3, 3, 3, 4] and workable arr [0, 0, 4, 9, 4]
then essentially it becomes house robber problem. If we rob house 4 then we can't rob house 9
which is same as saying if we delete 4, then we can't delete 9, we have to skip that.

TC O(n)+O(max(n)) as two loops can have different sizes based on input and max of input
SC O(max(n)) - as we use aux data structure of list for storing elements until max(n)
"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # base case
        if len(nums) == 0 or not nums:
            return -1
        
        m = max(nums) + 1 # built-in function to get max of the list, add +1 as list is 0 based
        
        arr = [0] * m    # create empty list with m elements
        
        for n in nums:  # O(n)
            arr[n] += n
        
        # once arr is constructed, we have reduced the problem to house robber problem
        dp0 = arr[0]
        dp1 = max(dp0,0+arr[1])  # at 0th index, just select nums[0], at 1st index choose max of 0th and 1st index
        
        for i in range(2,len(arr)): # O(max(n))
            dp1, dp0 = max(arr[i]+dp0, dp1), dp1
        
        return dp1    
        