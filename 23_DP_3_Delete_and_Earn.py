#Time Complexity : O(N) where N is the number of nums 
#Space Complexity : O(2n)=O(N) 
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :

#Your code here along with comments explaining your approach

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        if len(nums)==0: 
            return 0
        
        max_no=max(nums)
        
        arr=[0]*(max_no+1)
        
        for i in nums: 
            arr[i]+=1
        
        if len(arr)==0: 
            return 0 
        if len(arr)==1: 
            return nums[0]
        if len(arr)==2: 
            return max(arr[0], arr[1])
        
        dp=[float('-inf')]*(len(arr)+1) 
        
        dp[0]=arr[0]
        dp[1]=max(arr[0],arr[1])
        for i in range(2,len(arr)): 
            dp[i]=max(arr[i]*i+dp[i-2],dp[i-1])
        
        return dp[len(arr)-1]    
        
        