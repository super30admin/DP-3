class Solution:
    def deleteAndEarn(self, nums) :
        if nums == None or len(nums) == 0:
            return

        maxnum = float("-inf")
        for i in range(len(nums)):
            if maxnum < nums[i]:
                maxnum = nums[i]

        arr = [0] * (maxnum + 1)

        for num in nums:
            arr[num] += num

        skip = 0
        choose = arr[0]

        for i in range(len(arr)):
            prevskip = skip
            skip = max(skip, choose)
            choose = prevskip + arr[i]
        return max(skip, choose)

