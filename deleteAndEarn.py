class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        sums = {}
        maxItem = max(nums)
        curSum = 0
        prevSum = 0

        for num in nums:
            if num not in sums:
                sums[num] = 0
            sums[num] = sums[num] + num

        for i in range(1, maxItem + 1):
            temp = curSum
            cur = max(curSum, sums.get(i, 0) + prevSum)
            prevSum = temp

        return cur
