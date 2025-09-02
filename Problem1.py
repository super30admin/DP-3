"""
TC: O(Max(List)) {we only iterate till the maximum number in the list}
SC: O(Max(List)) {The house_robber array is the only array that we create}

Approach:

We first initialize the array and perform bubble sort to store the values since we know the values start from 1 till Max(List).
We then perform a simple house robber algorithm iteratively to calculate the earnings by taking into account the prev 2 earnings and
update them as we go.

The problem ran successfully on Leetcode.
"""


from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        house_robber = [0]*(max(nums)+1)
        #bucket sort
        for n in nums:
            house_robber[n] += n
        
        prev1, prev2 = 0, 0

        for each in house_robber:
            temp = max(prev1, each+prev2)
            prev2 = prev1
            prev1 = temp
        
        return prev1
