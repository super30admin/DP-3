#Time Complexity : O(n)
#Space Complexity : O(max_val)
#Any problem you faced while coding this : -

# The approach is to calculate the maximum points that can be earned by deleting some elements from the nums list, considering the rule that if an element is deleted, all its duplicates are also deleted. It uses dynamic programming to find the maximum cumulative sum of elements while skipping adjacent elements.

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None and len(nums) == 0:
            return 0
        max_val = 0
        for num in nums:
            max_val = max(max_val, num)
        
        arr = [0 for i in range(max_val+1)]
        for i in range(len(nums)):
            curr = nums[i]
            arr[curr] += curr

        prev = arr[0]
        curr = max(arr[0], arr[1])
        for i in range(2,len(arr)):
            temp = curr
            curr = max(curr, arr[i]+prev)
            prev = temp
        
        return curr