#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        result=[0]*((10**4)+1)
        for num in nums:
            result[num]=result[num]+num
        skip=0
        take=0
        for num in result:
            temp=max(take+num,skip)
            take=skip
            skip=temp
        return max(take,skip)