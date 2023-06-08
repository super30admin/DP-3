# Time complexity : O(m*n)
# Space complexity : O(1)

# The code ran on Leetcode
# Maintain an array to store count of all numbers, arr[i - 1] = (occurences of number i) * i.
# Now, the problem can be considered as a house robber problem, where arr[i] = max(arr[i-1], (arr[i-2] + arr[i])) 

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        if len(nums) == 1:
            return nums[0]

        arr = [0]*(max(nums))
        for n in nums:
            arr[n - 1] += n
            
        if len(arr) == 1:
            return arr[0]
        arr[1] = max(arr[1], arr[0])
        # Same as house robber
        for i in range(2, len(arr)):
            arr[i] = max(arr[i-1], arr[i] + arr[i-2])
        
        return arr[-1]
