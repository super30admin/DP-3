# problem 1 

# https://leetcode.com/problems/delete-and-earn/


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        points = {}
        max_val = 0 
        # find the max val and count all the number
        for num in nums:
            if num in points:
                points[num]+=num 
            else:
                points[num] = num 
            max_val = max(max_val,num)

        dp=[0]*(max_val+1)
        dp[1] = points[1] if 1 in points else 0

        for num in range(2,max_val+1):
            dp[num] = max(dp[num-1],dp[num-2]+points[num] if num in points else 0)
        return dp[max_val]