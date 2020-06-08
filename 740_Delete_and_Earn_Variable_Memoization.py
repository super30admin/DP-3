# Time Complexity : O(n X n) [n = number of elements in the list A]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 


# Your code here along with comments explaining your approach
# 1. 
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:return 0
        count_tables = [0 for i in range(max(nums)+1)]
        for num in nums:
            count_tables[num] += num
        prev_skip, prev_take = 0, count_tables[0]
        for i in range(1,max(nums)+1):
            temp = prev_skip
            prev_skip = max(prev_skip, prev_take)
            prev_take = max(prev_take, temp + count_tables[i])
        return max(prev_skip, prev_take)