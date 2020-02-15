'''
Dp Solution
Time Complexity :O(max)
Space Complexity: O(max) max of the numbers
Did this code successfully run on Leetcode : Yes
Explanation:
Create a DP with length of max value and iterate through the input list add the number to the respective index in the auxilary list.
Next create variables to choose skip or not, we then assign skip to be max(skip,take) and take to be skip + the new array[i]
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0

        max1 = max(nums)
        l = [0 for x in range(0 ,(max1 ) +1)]

        for i in range(0, len(nums)):
            if l[nums[i]] == 0:
                l[nums[i]] = nums[i]
            else:
                l[nums[i]] =  l[nums[i]] + nums[i]
        skip =0
        take = 0
        for i in range(0, len(l)):
            tempS = max(skip, take)
            tempT = skip + l[i]
            skip = tempS
            take = tempT

        return max(skip, take)
