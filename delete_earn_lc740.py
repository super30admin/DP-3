"""
Name: Srinidhi Bhat
Time Complexity: O(n) - Single for loop iteration
Space Complexity: O(n) - Constructing points array

Did it Run on Leetcode: Yes 
Logic: Can convert this to the Robber question. 
Sum up all the numbers and then use Dp to find the maximum possible value using DP
"""
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        points = [0]*(10001)
        
        for i in nums:
            points[i]+=i #need sum of all elements which are i
        
        prev = curr = 0
        for value in points:
            prev,curr = curr,max(prev+value,curr)
        return curr