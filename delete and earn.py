# Time Complexity: O(n*m) m is the max(nums)
# Space Complexity: O(m) m is the max(nums)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        arr = [0] * (max(nums)+1)
        # print(arr)
        for num in nums:
            arr[num] += num
        arr[1] = max(arr[0], arr[1])
        for i in range(2, len(arr)):
            arr[i] = max(arr[i-1], (arr[i] + arr[i-2]))

        return arr[-1]