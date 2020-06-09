#LC 740 - Delete and Earn
#Time Complexity - O(n+max(arr))
#Space Complexity - O(max(arr))
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        n = max(nums)
        #print(n)
        tmp = [0]*(n+1)
        for i in nums:
            tmp[i] = tmp[i] + i
        #print(tmp)
        dp = []
        for i in range(n+1):
            dp.append([0,0])
        dp[0][1] = tmp[1]
        for i in range(n+1):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = tmp[i] + dp[i-1][0]
        return max(dp[-1][0],dp[-1][1])
            