# DP
# Submitted successfully
# TC = O(n) + O(max(n)), SC = O(max(n))
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0 or nums == None:
            return 0

        # array to put nums[i] in indexes
        indArr = [0 for a in range(max(nums) + 1)]

        # [2,2,3,3,3,4] becomes [0,0,4,9,4]
        for i in range(len(nums)):
            j = nums[i]
            indArr[j] += j

        # usual DP pattern with 2 variables
        skip = 0
        take = indArr[0]

        for k in range(1, len(indArr)):
            temp = skip  # as it is needed ahead
            skip = max(skip, take)  # 0 case
            take = temp + indArr[k]  # 1 case

        return max(skip, take)