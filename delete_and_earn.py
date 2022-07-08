"""
TC:O(n)
SC:O(n)
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        arr=nums
        sum_arr=[0]*(max(arr)+1)
        for i in arr:
            sum_arr[i]+=i
        dp = [[0 for i in range(max(arr)+1)] for j in range(2)]
        for i in range(1,len(dp[0])):
            dp[0][i]=max(dp[0][i-1],dp[1][i-1])
            dp[1][i]=dp[0][i-1]+sum_arr[i]

        return max(dp[0][-1],dp[1][-1])