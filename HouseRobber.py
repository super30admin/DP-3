from pip import List
#Time Complexity = O(n)
# Space Complexity = O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        first = 0
        next = 0
        temp = 0
        for i in range(len(nums)):
            test = max(temp,next)
            next = nums[i] + temp
            temp = test
        return max(test,next)
        