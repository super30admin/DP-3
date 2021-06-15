class Solution:
    def deleteAndEarn(self, nums):
        if nums == None or len(nums) == 0:
            return 0

        values = [0] * (max(nums) + 1)
        skip = 0
        take = 0

        for num in nums:
            values[num] += num

        for i in range(1,len(values)):
            c_skip = max(skip, take) 
            c_take = values[i] + skip
            skip = c_skip
            take = c_take

        return max(skip, take) 