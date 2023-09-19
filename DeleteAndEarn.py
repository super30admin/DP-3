class Solution:
    def deleteAndEarn(self, nums: list[int]) -> int:
        maxIndex = max(nums) + 1
        preList = [0] * maxIndex
        
        initial = 0
        for i in range(0, len(nums)):
            index = nums[i]
            preList[index] += nums[i]
        skip = 0
        take = preList[0]
        for i in range( 0, len(preList)):
            tempSkip = skip;
            skip = max(skip, take)
            take = tempSkip + preList[i]
        return max(skip, take)

object = Solution()
print(object.deleteAndEarn([2, 2, 3, 3, 3, 4]))
        