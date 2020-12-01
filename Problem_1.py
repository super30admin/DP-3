# Delete and Earn

# Time Complexity : O(N logN) where N is the length of nums
# Space Complexity : O(N) as the size of variable maximum.
# Did this code successfully run on Leetcode : Yes, Runtime: 112 ms and Memory Usage: 14 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
After trying the greedy algorithm and recursive approach and being unsuccesful in finding the maximum points
Dynamic Approach is used by implementing a 1D array of size equal to the maximum element in the given array, 
and fill this array with the given array elements, in such a way that
element i goes to the index i, so [1,2,2,3] becomes,[0,1,4,3]. In other words it 
is reduced as the problem similar to House robber. 
"""
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(len(nums)==0 or nums==None): # Edge Cases
            return 0
        maximum=sys.maxsize # Assigning a large number
        for num in nums:
            maximum=max(maximum,num)
        dp=[0] * 10001 # Assigning it as maximum+1
        for num in nums:
            dp[num]+=num
        skip=0           # As House Robber Problem
        take=0
        for i in range(len(dp)):
            temp=max(skip,take)    
            take=skip+dp[i]
            skip=temp
        return max(skip,take)

