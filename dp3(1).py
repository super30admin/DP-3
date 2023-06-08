"""
Problem : 1

Time Complexity : O(1)
Space Complexity : O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

First converting the input array into another array which stores summation of the total occurence of each number
and then using the DP solution of not choosing adjacent elements to get the maximum earnings

"""

# Delete and earn

class Solution(object):
    def deleteAndEarn(self, nums):
        # as the maximum value input can achieve is 10000
        count=[0 for _ in range(10001)]

        for i in nums:
            count[i]+=i
        
        prev=count[0]
        curr=max(count[0],count[1])
        

        for i in range(2,len(count)):
            temp=curr
            curr=max(curr,prev+count[i])
            prev=temp


        return curr