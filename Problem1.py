# Problem 1 : Delete and Earn
# Time Complexity : O(n + maxValue) where n is the number of elements in the array
# Space Complexity : O(maxValue) where maxValue is the maximum value in the nums array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        # edge case if the nums array is None or length is 0 then return 0
        if nums is None or len(nums) == 0:
            return 0
        # get the maximum value from the nums list
        maxValue = max(nums)
        # get the length of the nums list
        length = len(nums)
        # define arr with the length as maxValue+1 and fill with 0
        arr = [0] * (maxValue+1)
        # loop through arr from 0 to length of the nums
        for i in range(length):
            # store the value of ith position of nums in current
            current = nums[i]
            # add the current to the value at current th position in arr array
            arr[current] += current
        # define prev and current. Set the prev to arr[0] and current to maximum between arr[0] and arr[1]
        prev = arr[0]
        current = max(arr[0], arr[1])
        # loop from second element to the last element in the array arr
        for i in range(2, len(arr), 1):
            # store current in temp since current will be updated
            temp = current
            # calculate the current as maximum between current and sum of arr[i] and prev value
            current = max(current, arr[i] + prev)
            # set prev to temp
            prev = temp
        # return the current value
        return current
        