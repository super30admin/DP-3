'''
Time Complexity - O(n) where n is length of list
Space Complexity = O(n) where n is the length of the new array
'''


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        arr = []
        max_num = max(nums)
        arr = [0 for i in range(max_num+1)]
        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
        prev = arr[0]
        curr = arr[1]
        for i in range(2, len(arr)):
            temp = curr
            curr = max(curr, prev+arr[i])
            prev = temp
        return curr
