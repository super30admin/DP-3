"""
Time Complexity : O(N + m), n is the len of nm and m is the max element in nums
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes


Your code here along with comments explaining your approach
Problem_1:  Delete and Earn
"""

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if (len(nums) == 0 or nums == []): return 0
        n = len(nums)
        max_num = nums[0]
        
        for i in range(n):
            max_num = max(max_num, nums[i])
           
        arr = [0 for _ in range(max_num + 1)]
        
        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
            
            
        prev = 0
        curr = arr[1]
        
        for i in range(2, len(arr)):
            temp = curr
            
            curr = max(curr, prev + arr[i] )
            
            prev = temp
            
        return curr