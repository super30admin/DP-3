"""
s30 - flavor of house robber problem. Modify the given nums array to the array of indicies representing the numbers and values representing the contributions. use that new array in the house robber algo because here also:
1. We cannot choose adjacent elements
2. we have to maximise the profit
the algo says-
you have 2 choices - choose or not choose. 
1. If chosen - the profit at arr[i] = profit at arr[i-1] if it was not chosen + arr[i]
2. if not chosen - the profit at arr[i] = max(profit at arr[i-1] if it was not chosen , profit at arr[i-1] if it was chosen)

TC: O(N)
SC = O(N)
where N = number of elements in nums

Did this code successfully run on Leetcode : yes
"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #create an array of contributions
        contributions = [0 for x in range(0, max(nums)+1)]
        for i in range(0, len(nums)):
            contributions[nums[i]] += nums[i]
        skip = 0
        take = contributions[0]
        for i in range(1, len(contributions)):
            skip, take = max(skip, take), skip + contributions[i]
        return max(skip, take)