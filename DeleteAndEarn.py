class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # Time Complexity is O(n)
        # Space Complexity is O(n)
        
        # Consider the input [2,2,3,3,3,4]
        # First Hash the elements given into a new array indices
        hashed = [0]*(max(nums)+1)
        for num in nums:
            hashed[num]+=num
        
        # After hashing we have [0,0,4,9,4]
        # Now this problem boils down to House Robber problem
        pick = hashed[0]
        skip = 0
        for i in range(len(hashed)):
            temp = skip
            skip = max(skip,pick)
            pick = hashed[i] + temp
        return max(skip,pick)