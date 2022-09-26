# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach

class Solution(object):
    def rob(self, nums):
        #Base case
        if not nums or len(nums) == 0:
            return 0

        n = len(nums)
        col = 2
        #Creating dp array
        dp = [[0 for j in range(col)] for i in range(n)]
        dp[0][1] = nums[0] #assigning the first row with the first element

        for i in range(1, len(nums)):
            #When the robber does not choose to rob the house
            dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            #When the robber chooses to rob the house
            dp[i][1] = nums[i] + dp[i-1][0]
        return max(dp[n-1]) #returning the max amount robbed in the end

if __name__ == "__main__":
    hr = Solution()
    nums = [2,7,9,3,1]
    ans = hr.rob(nums)
    print(ans)