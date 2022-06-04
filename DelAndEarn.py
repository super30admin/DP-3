# Time Complexity: O(n) + O(max(m))
# Space Complexity: O(max(m))
  
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        maxN = 0
        if len(nums) == 1:
            return nums[0]
        
        for num in nums:
            maxN = max(maxN, num)
        
        arr = [0 for i in range(maxN+1)]
        
        for num in nums:
            arr[num] += num
        
        prev = arr[0]
        curr = max(arr[0], arr[1])
        for i in range(2, len(arr)):
            temp = curr
            curr = max(curr, prev+arr[i])
            prev = temp
        
        return curr
        
