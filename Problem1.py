# Time Complexity : O(n) where n is the number of rows which is the length of array and  then number of columns are 2 which is constant and can be ignored
# Space Complexity : O(n) is size of the elements in the matrix 
# Did this code successfully run on Leetcode :  Yes 
# Any problem you faced while coding this : Yes it is difficult ot create a 2D array in python


# Your code here along with comments explaining your approach : - Similar approach to house robber where we decide to select the elements but not adjacent to it. And here we just make an array where we add up the elements and then use that array for decision


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        n = max(nums)
        m = len(nums)
        newSumArr = []
        dp= []
        for i in range(n+1):
            newSumArr.append(0)
        
        for i in range(m):
            newSumArr[nums[i]] = newSumArr[nums[i]]+nums[i]
        for i in range(n+1):
            cols = []
            for i in range(2):
                cols.append(0)
            dp.append(cols)
        for i in range(1,n+1):
            for j in range(2):
                if j == 0:
                    dp[i][j] = max(dp[i-1][j],dp[i-1][j+1])
                else:
                    dp[i][j] = dp[i-1][j-1] + newSumArr[i]
        return max(dp[n][0],dp[n][1])