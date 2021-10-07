#Time Complexity = O(n)
#Space Complexity = O(n)
#Compiled and run on leetcode

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        if (nums == None and len(nums) == 0):
            return 0

        nums.sort() #first need to sort given array

        n = max(nums) + 1
        dp = [0] * n # create dp matrix

        for i in nums: #store the count of total value for each element in array
            dp[i] += i

        c, dc = 0, 0

        for i in range(0, len(dp)): #dp logic of chose or dont chose
            temp = dc
            dc = max(c, dc)
            c = temp + (dp[i])

        return (max(c, dc))
