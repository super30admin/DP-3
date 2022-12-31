# Time Complexity :O(n+max(nums))
# Space Complexity :O(max(nums))
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

class Solution(object):
    def deleteAndEarn(self, nums):
        m=max(nums)
        arr=[0 for i in range(m)]
        for i in nums:
            arr[i-1]+=i
        prev=0
        curr=0
        for i in arr:
            temp=curr
            curr=max(curr,prev+i)
            prev=temp
        return curr
        
        
       
       