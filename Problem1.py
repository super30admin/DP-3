# Time Complexity : O(max(nums)) or O(n) where n in length of nums ; whichever is larger
# Space Complexity : O(max(nums)) used for hashmap.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Class Solution.
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        max_of_array = max(nums)
        hm = [0] * (max_of_array+1)
        for i in nums:
            hm[i] += i
        dp = [[0 for i in range(2)] for j in range(len(hm))]
        dp[0][0] = 0
        dp[0][1] = hm[0]
        for i in range(1,len(dp)):
            dp[i][0] = max(dp[i-1][0],dp[i-1][1])
            dp[i][1] = dp[i-1][0] + hm[i]
        return max(dp[len(hm)-1])
