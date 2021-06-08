# // Time Complexity : O(n)
# // Space Complexity : O(m) Where m is the maximum value in the input array
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None:
            return 0
        m = max(nums)
        arr = [0] * (m + 1)

        for i in range(len(nums)):
            index = nums[i]
            arr[index] += nums[i]

        skip = 0
        take = arr[0]

        for i in range(len(arr)):
            temp = skip
            skip = max(skip, take)
            take = temp + arr[i]

        return max(skip, take)




