# Time Complexity : O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if (len(nums)==0 or nums is None): return 0
        max_val = -float('inf')
        for num in nums:
            max_val = max(max_val, num)
        arr = [0]*(max_val+1)
        for num in nums:
            arr[num] += num;
        
        prev = arr[0]
        curr = arr[1]
        for i in range(2, len(arr)):
            temp = curr
            curr = max(curr, prev + arr[i])
            prev = temp
        
        return curr

sc = Solution()
nums = [3,4,2]
print(sc.deleteAndEarn(nums))
        