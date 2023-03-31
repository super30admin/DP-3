

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
"""
create an array of length maximum value of nums + 1. Fill out the array with summing repeated elements.
go over each element of array. If we choose not to select the element take max of previous and if we choose to select the element do not take element before that but sum up dp[0] and current element
retun max of dp list
"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:


        arr = [0 for i in range(max(nums)+1)]

        for ele in nums:
            arr[ele] += ele
            
        dp = [0,arr[0]]

        for i in arr:
            dp = [max(dp), dp[0]+i]

        return max(dp)
