#Time complexity: O(n)+ O(max(nums))  
#Space complexity: O(max(nums)) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # find maximum number in array
        maxNum = max(nums)
        #make list of maximum number size
        sumList = [0 for el in xrange(maxNum+1)]
        
        #populate list acc to actual array with position defining element and item defining sum of elements in the array
        for el in nums:
            sumList[el] += el
        
        #problem converts to house robber
        skip,take = 0,sumList[0]
        
        #iterate over new list
        for el in sumList:
            temp = skip
            #for skip consider max of prev, for take, consider prev skip and item
            skip = max(skip,take)
            take = temp+el
        #final answer
        return max(skip,take)