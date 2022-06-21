# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
def deleteAndEarn(self, nums: List[int]) -> int:
        data = [0 for _ in range(0, max(nums)+1)]
        for i in nums:
            data[i] = data[i] + i
        dp = [[0 for _ in range(0,2)] for _ in range(len(data))]
        for i in range(1,len(dp)):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = dp[i-1][0] + data[i]
        return max(dp[len(dp)-1][0], dp[len(dp)-1][1])
        