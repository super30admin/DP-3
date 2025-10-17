# Time complexity: O(n) after using memoization.
# Space: O(n) for using memo hash map

# The intuition is first create a nums array with the total count of each element. Then the problems easier to implement with 0 and 1 strategy. Where we chose one and not chose one.
# This is recursive dp solution top down.

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        numsArr = [0] * (max(nums) + 1)
        self.memo = {}
        for i in range(len(nums)):
            numsArr[nums[i]] += nums[i]

        def helper(arr, idx):
            if idx >= len(arr): return 0

            if idx in self.memo: return self.memo[idx]

            case1 = arr[idx] + helper(arr, idx + 2)

            case2 = helper(arr, idx + 1)

            self.memo[idx] = max(case1, case2)

            return self.memo[idx]

        return helper(numsArr, 0)

    # The time complexity is same: O(n). However, the space is efficient with O(1)
    def deleteAndEarnBottomUp(self, nums: List[int]) -> int:
        numsArr = [0] * (max(nums) + 1)
        self.memo = {}
        for i in range(len(nums)):
            numsArr[nums[i]] += nums[i]
        n = len(numsArr)

        rob1 = 0
        rob2 = numsArr[n - 1]
        for i in range(n - 2, -1, -1):
            temp = rob2
            rob2 = max(rob2, numsArr[i] + rob1)
            rob1 = temp

        return rob2


