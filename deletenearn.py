#https://leetcode.com/problems/delete-and-earn/
#time-o(max(n))
#space-o(max(n))
import sys
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        max1=-sys.maxint
        for i in nums:
            if i>max1:
                max1=i
        a=[0]*(max1+1)
        for i in nums:
            a[i]+=i
        #print(a)
        skip=0
        choose=a[0]
        for i in range(1,len(a)):
            prev=skip
            skip=max(skip,choose)
            choose=prev+a[i]
        print(a)
        return max(skip,choose)