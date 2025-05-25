# // Time Complexity : o(max(n,max(nums))) - n is the length of nums array
# // Space Complexity : o(1) +o(max(nums))
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : 
# used the old array to reference instead of array fromed after transformation


# // Your code here along with comments explaining your approach
# 1) idea consolidate the earnings(add similar ones together) and make a new indexed array (since we have to delete adjacent elements) the problem becomes similar to houserobber
# 2) once this is done calculate the dp matrix since the solution of ith index is given by either the i-1 or nums[i] + dp[i-2]
# 3) the above approach can be simplified with 1d array by keeping track of prev and curr

from typing import List
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums or len(nums) == 0 : return 0
        n = len(nums)
        maxVal = float('-inf')
        for n in nums:
            maxVal = max(maxVal, n)
        
        arr = [0]*(maxVal +1)
        for n in nums:
            arr[n]+=n
        # similar to house robber
        prev = arr[0]
        curr = max(arr[0], arr[1])
        for i in range(2, maxVal+1):
            temp = curr
            curr = max(curr, prev + arr[i])
            prev = temp
        return curr
         
