## Problem1: (https://leetcode.com/problems/delete-and-earn/)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        """
        Calculates the maximum points you can earn by deleting elements.
        
        Time Complexity: O(N + M)
        - N is the number of elements in `nums`.
        - M is the maximum value in `nums`.
        Finding the max takes O(N). Initializing and iterating through the 
        `sumOfFreq` array takes O(M). Populating it takes O(N). 
        Total Time = O(N) + O(M) + O(N) + O(M) = O(N + M).
        
        Space Complexity: O(M)
        - We create an array `sumOfFreq` of size M + 1. 
        - The DP variables (previous, current, temp) only use O(1) space.
        Total Space = O(M).
        """
        # Time: O(N) to find the maximum element
        maxInArr = max(nums)
        
        # Space: O(M) for an array of size maxInArr + 1
        # Time: O(M) to initialize
        sumOfFreq = [0 for _ in range(maxInArr + 1)]
        
        # Time: O(N) to iterate through nums and populate the frequency sum
        for n in nums:
            sumOfFreq[n] += n
            
        n = len(sumOfFreq)
        
        if n == 2:
            return sumOfFreq[1]
            
        previous = sumOfFreq[0] 
        current = max(previous, sumOfFreq[1])
        
        # Time: O(M) to iterate through the sumOfFreq array
        for i in range(2, n):
            # Space: O(1) for temporary variables
            temp = max(current, sumOfFreq[i] + previous)
            previous = current
            current = temp
            
        return current