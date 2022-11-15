#Time Complexity: O(max(nums))
#Space Complexity: O(max(nums))
#Successfully ran on leetcode

class Solution:
    def deleteAndEarn(self, nums: list(int)) -> int:
        arr = []
        maximum = max(nums)
        for i in range(maximum+1):
            arr.append(0)
        for i in range(len(nums)):
            arr[nums[i]]+=nums[i]
        skip,take=0,arr[0]
        for i in range(1,len(arr)):
            temp = skip
            skip = max(skip,take)
            take = temp+arr[i]
        return max(skip,take)