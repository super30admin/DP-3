# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : A bit in python 


# // Your code here along with comments explaining your approach


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0 or nums==None:
            return 0
        
        if len(nums)==1:
            return nums[0]
        

        # making an arry of max length of the nums array
        maximum=nums[0]
        for i in range(0,len(nums)):
            maximum=max(maximum,nums[i])
            
        
        #making the sum of each elemnt into their respective index
        dp=[0]*(maximum+1)
        for i in range(len(nums)):
                dp[nums[i]]+=nums[i]
        

        #same robber trick to find the max using 2 pointers
        prev=0
        curr=max(prev,dp[1])
        for i in range(2,len(dp)):
            temp=curr
            curr=max(curr,prev+dp[i])
            prev=temp
        
        return curr