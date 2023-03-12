# Time Complexity: O(n) + O(maxVal)
# Space Complexity: O(maxVal)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxVal = 0 
        for i in range(len(nums)):
            if maxVal < nums[i]:
                maxVal = nums[i] 
        arr = [0] * (maxVal + 1)
        
        for i in range(len(nums)): 
            arr[nums[i]] += nums[i]

        prev = arr[0]
        curr = max(arr[0], arr[1])
        
        for i in range(2, len(arr)):
            temp = curr 
            curr = max(prev + arr[i], curr)
            prev = temp 
        
        return curr
