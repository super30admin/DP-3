##Time Complexity : O(n)
##Space Complexity :O(nlogn)
##Did this code successfully run on Leetcode : Yes

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = Counter(nums)
        nums = sorted(list(set(nums)))
        
        earn, earn1 = 0, 0
        for i in range(len(nums)):
            cearn = nums[i] * count[nums[i]]
            if i > 0 and nums[i] == nums[i-1] + 1:
                temp = earn1
                earn1 = max(cearn + earn, earn1)
                earn = temp
            else:
                temp = earn1
                earn1 = cearn + earn1
                earn = temp
        return earn1
                    
        