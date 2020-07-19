# Time Complexity O(n) where n is the maximum element
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        maximum = max(nums)
        a = [0 for i in range(maximum+1)]
        if not nums:
            return 0
        else:
            for i in range(len(nums)):
                a[nums[i]] += nums[i]

            d = [[0 for i in range(2)] for j in range(maximum+1)]


            for j in range(1, len(d)):
                d[j][0] = max(d[j-1][0],d[j-1][1])
                d[j][1] = a[j] + d[j-1][0]

            return max(d[maximum][0], d[maximum][1])
