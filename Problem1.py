# https://leetcode.com/problems/delete-and-earn/description/

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Recursive approach (exhaustive)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return nums[0]

        maxNum = 0

        for num in nums:
            maxNum = max(maxNum, num)
        
        arr = [0] * (maxNum+1)

        for num in nums:
            arr[num] += num

        return self.helper(arr, 0, 0)

    def helper(self, arr, i, earnings):

        if i >= len(arr): return earnings

        case0 = self.helper(arr, i+1, earnings)

        case1 = self.helper(arr, i+2, earnings + arr[i])

        return max(case0, case1)
    
# DP solution

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = len(nums)

        maxVal = 0
        for n in nums:
            maxVal = max(maxVal, n)

        arr = [0] * (maxVal+1)
        dp = [0] * (maxVal+1)

        m = len(arr)

        for num in nums:
            arr[num] += num

        dp[0] = arr[0]
        dp[1] = max(arr[0], arr[1])
        
        for i in range(2, maxVal+1):
            dp[i] = max(dp[i-1], arr[i]+ dp[i-2])

        return dp[m-1]
    
# DP using prev and curr

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = len(nums)

        maxVal = 0
        for n in nums:
            maxVal = max(maxVal, n)

        arr = [0] * (maxVal+1)
        dp = [0] * (maxVal+1)

        m = len(arr)

        for num in nums:
            arr[num] += num

        prev = arr[0]
        curr = max(arr[0], arr[1])
        
        for i in range(2, maxVal+1):
            temp = curr
            curr = max(curr, arr[i]+ prev)
            prev = temp

        return curr
    