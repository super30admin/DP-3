# DP
# Works best if input is sorted
# Submitted successfully
# TC = O(nlogn), SC = O(1)
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        nums = sorted(nums)   # necessary to make the below logic work

        skip = 0    # base 0 case
        take = nums[0]  # base 1 case

        for i in range(1, len(nums)):
            if nums[i] == nums[i-1]:
                #1 case
                take += nums[i]
            else:
                # 0 case
                temp = skip
                skip = max(skip, take)
                if nums[i] - nums[i-1] > 1:
                    # 1 case
                    take = max(temp, take) + nums[i]
                else:
                    # 1 case
                    take = temp + nums[i]

        return max(skip, take)