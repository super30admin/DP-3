# // Time Complexity : O(n)
# // Space Complexity :O(n+max(n))
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No


# We create an array dp that will hold the equilant value of each value. For example if we have three 1s then dp[1]=3(1+1+1)
# now we have two variables to store prev and current since we cant delete adjacent cells.
# usign these variables we updated the dp array and at the end of the array the last index of dp will give us the max value we can get
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        dp=[0]*(max(nums)+1)
        dp[0]=0
        for num in nums:
            dp[num]+=num
        prev = dp[0]
        curr=max(dp[0], dp[1])
        for i in range(2,len(dp)):
            temp=curr
            curr=max(curr, prev+dp[i])
            prev=temp
        return curr