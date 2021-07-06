# Time Complexity : O(max(len(nums), max(nums)))
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : y
# Any problem you faced while coding this : n


# Your code here along with comments explaining your approach

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        
        maxVal = -sys.maxint
        
        # updating max
        for i in nums:
            if maxVal < i:
                maxVal = i
        
        # max+1
        arr = [0]*(maxVal+1)
        
        for i in nums:
            arr[i] += i
            
        skip = 0
        choose = arr[0]
        for i in range(len(arr)):
            prevSkip = skip
            skip = max(skip, choose)
            choose = prevSkip + arr[i]
            
        return max(skip, choose)


# creating another list and storing sum of the total occurance of an index, at that particular index
# and problem becomes just like HouseRobber #198