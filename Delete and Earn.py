class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
            
        if(len(nums) == 1):
            return nums[0]
        
        C = 0
        DC = 0
        Max = max(nums) + 1
        interim = [0] * Max
        
        for num in nums:
            interim[num] += num
        
        for _ in interim:
            temp = DC
            DC = max(C, DC)
            
            C = _ + temp
        
        return(max(C, DC))
