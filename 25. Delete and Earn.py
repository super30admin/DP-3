class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums is None or len(nums) == 0:
            return 0

        maximum = max(nums)

        arr = [0] * (maximum + 1)
        skip, take = 0, arr[0]
        for num in nums:
            arr[num] = arr[num] + num

        print(arr)

        for i in range(0, len(arr)):
            prevSkip = skip

            skip = max(skip, take)

            take = prevSkip + arr[i]

        return max(skip, take)
