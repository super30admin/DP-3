#Time Complexity :o(n)
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(nums==None or len(nums)==0):
            return 0
        
        maxi=max(nums)
        arr=[0]*(maxi+1)
        
        for i in nums:
            arr[i]+=i
        
        leave=0
        take=0
        for i in range(len(arr)):
            temp=leave
            leave=max(leave,take)
            take=temp+arr[i]
        return max(leave,take)
            