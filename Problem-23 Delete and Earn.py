# 740. Delete and Earn
# https://leetcode.com/problems/delete-and-earn/

# Time complexiety: O(max(nums))
# Space complexiety: O(max(nums))

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:\
        # Find max value in the input
        maxVal = max(nums)

        freq = [0 for i in range(maxVal+1)]

        # Make a list of freq upto max value
        for i in range(len(nums)):
            freq[nums[i]] += nums[i]
        
        # Similar to House Robber
        notTaken = 0
        taken = 0

        for i in range(maxVal+1):
            temp = notTaken
            notTaken = max(notTaken,taken)
            taken = freq[i] + temp
        return max(notTaken,taken)