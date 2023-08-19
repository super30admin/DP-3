# DP Solution
# Time Complexity = O(N)
# Space Complexity = O(N)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxNum = 0
        for num in nums:
            maxNum = max(maxNum , num)
        arr = [0]*(maxNum+1)
        for i in range(len(nums)):
            curr = nums[i]
            arr[curr]+=curr
        # House robber array
        dp = [0]* len(arr)
        dp[0] = arr[0]
        dp[1] = max(arr[1],arr[0])
        for i in range(2,len(arr)):
            dp[i] = max(dp[i-1],dp[i-2]+arr[i])
        print(dp)
        return dp[-1]