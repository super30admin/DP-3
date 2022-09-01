'''
740. Delete and Earn

TIME COMPLEXITY: O(N) + O(N) + O(N) = O(N)
SPACE COMPLEXITY: O(max(nums))
LEETCODE: Yes
DIFFICULTIES: Nope, as I have already attended the class
'''

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        n = len(nums)
        if n == 1:
            return nums[0]
        
        res = 0
        mv = nums[0] # max value in the nums
        
        for i in nums:
            if i > mv:
                mv = i
        
        arr = [0 for i in range(0, mv+1)]
        
        for i in nums:
            arr[i] += i
        
        if len(arr) == 2:
            return arr[1]
        arr[2] = max(arr[1], arr[2])
        
        for i in range(3, len(arr)):
            arr[i] = max(arr[i-1], arr[i-2]+arr[i])
        
        return arr[len(arr)-1]
