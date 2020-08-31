# Leetcode problem link : https://leetcode.com/problems/delete-and-earn/
# Time Complexity : O(n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Optimized approach: DP in O( n ) => The intutiion behind this approach is DP. Reducing the problem to an array f choose and not choose options so that the max sum can be calculated by choosing or not choosing element at each index.
        One pre-condition or assumption here is if you select an element, all other ocuurrences of the same element can be selected ( as we have already deleted element+1 and element -1 from the array so its most beneficial to select all elements with same value to gain more points. Hence we can conviniently convert this list to cumulative sum list with all elements as sum of same occurrences of the element.
        1. Create a counter list of size equal to the max element in the list.
        2. Add the element to its counter array at index = element
        3. Traverse through this counter array
        4. Choosing element will be current element plus not choosing previous element
        5. Not choosing current element will be max of choosing and not choosing prev element
        6. At the end we return the max of choosing and not choosing last element (as it keeps into account the max at each step of choosing and not choosing each element)
  
 '''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        c = 0
        dc = 0
        
        counterNums = [0 for _ in range(self.getMaxNums(nums)+1)]
        for num in nums:
            counterNums[num] += num
        
        for num in counterNums:
            temp = dc
            dc = max(c, temp)
            c = temp + num
        
        return max(c,dc)
    
    def getMaxNums(self,nums):
        max_val = 0
        for num in nums:
            if max_val < num:
                max_val = num
        return max_val