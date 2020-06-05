# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) == 0:
            return 0
        #cocatinate all the sanem numbers in helper and save them
        helper = [0] * (max(nums)+1)
        for num in nums:
            helper[num] +=num
        dp = [0] * (max(nums)+1)
        for i in range(1,len(dp)):
            #sum the helper of position to the one before the one you at by two "as you have delete the ones near you or not use the one you ate and get the one before it if bigger"
            dp[i] = max(helper[i]+dp[i-2],dp[i-1])
        # see if taking the last position or not taking it would get you a bigger sum
        return max(dp[-1],dp[-2])