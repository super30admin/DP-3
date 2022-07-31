"""


740. Delete and Earn

Time Complexity : O(M)

m = max value in nums array

Space Complexity : O(M)


Did this code successfully run on Leetcode : Yes

First we are creating a array that stores the total sum of the num as per the idx value
Then using this array to fing the max using the house robber pattern

We are using two pointers curr and prev

As the condition states:
     return the maximum amount of money you can rob  by choosing the alterantive houses to avoid alarns
    
So the max of max( curr , prev + arr[i]) is calculated

where for I
 curr is i-1
 prev = i-2
@name: Rahul Govindkumar_RN27JUL2022
"""


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        if(len(nums) == 0):
            return 0
        
        
        
        maxN = max(nums)
        
        arr=[0]*(maxN+1)
        
        for idx,val in enumerate (nums):
            arr[val] += val
            
        prev =0
        curr = arr[1]
        
        for i in range (2,len(arr)):
            temp =curr
            curr = max( curr , prev + arr[i])
            prev = temp
            
        return curr
        