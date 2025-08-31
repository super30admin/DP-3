"""
Time: O(n + k),  Space: O(k)   where n = len(nums), k = max(nums)
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        arr = [0] * (max(nums) +1)

        for num in nums: 
            arr[num]+=num

        dp = [0 for _ in range(len(arr))]

        if len(arr) == 1: 
            return arr[0]

        dp[0] = arr[0]
        dp[1] = max(arr[0], arr[1])

        for i in range(2, len(arr)): 
            dp[i] = max(dp[i-1], arr[i]+dp[i-2])

        return dp[-1]
