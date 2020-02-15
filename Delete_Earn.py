#// Time Complexity : O(maximum element in the given array nums)
#// Space Complexity : O(maximum element in the given array nums)
#// Did this code successfully run on Leetcode : Yes
#// Any problem you faced while coding this : No


#// Your code here along with comments explaining your approach
#In this problem first we take the maximum element in the list and create a new array with that size and fill the newly created array at #the index where element value is equal to index and keep on adding the value to that index till we are donw with all the elements.with #the newly created array we can use the same logic used for the problem House_robber.we get the maximum number of points by taking the #maximum of the last row.

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if nums == None or len(nums) == 0:
            return 0
        
        out=[0]*(max(nums)+1)
        
        for i in range(len(nums)):
            out[nums[i]] = out[nums[i]]+nums[i]
        out1=[[None for i in range(2)] for j in range(len(out))]
        
        for i in range(len(out1)):
            if i==0:
                out1[i][0]=0
                out1[i][1]=out[i]
            else:
                out1[i][0] = max(out1[i-1][0], out1[i-1][1])
                out1[i][1] = out1[i-1][0] + out[i]
        return max(out1[len(out)-1][0], out1[len(out)-1][1])