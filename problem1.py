# Time Complexity : O(maxValue+ n) where maxValue is max element and n is length of an array
# Space Complexity: O(maxValue+ n) where maxValue is max element and n is length of an array
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0
        maxValue = float('-inf')
        for num in nums:
            maxValue = max(maxValue, num)

        arr = [0] * (maxValue + 1)

        for num in nums:
            arr[num] = arr[num] + num

        skip = 0
        take = arr[0]

        for i in range(1, maxValue + 1):
            temp = skip
            skip = max(skip, take)

            take = temp + arr[i]

        return max(skip, take)



