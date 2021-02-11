# TC: O(max(maxNumber, n))
# SC: O(maxNumber)
# LeetCode: Y(https://leetcode.com/problems/delete-and-earn)
# Approach: Preprocess the input list into a list where each index has a cumulative value of that index in input list
#           After creating such a list, track teo variables: skip and take for each option and return the max(house robber)


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxNumber = max(nums)
        
        dp = [0 for _ in range(maxNumber + 1)]
        
        # preprocess the input list
        for num in nums:
            dp[num] += num
        
        # initialize skip and take
        skip, take = 0, 0
        
        # process the dp list
        for index, value in enumerate(dp):
            # get max 
            temp = max(skip, take)
            # add value to previously skipped values
            take = skip + value
            
            # retain the max of previously skipped or taken for the previous 
            skip = temp
            
        return max(skip, take)
        
