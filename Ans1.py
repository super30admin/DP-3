# Time Complexity :  O(m + n) -> O(max(n) + n)
# Space Complexity : O(m)
# Did this code successfully run on Leetcode : Yes      
# Any problem you faced while coding this : No  

# Your code here along with comments explaining your approach: This is a recursion based problem with overlapping subproblems. Create an array having size equal to the maximum value in the nums array. Store the frequency of a value at the index of that value. After that we solve it like the house robber problem. 


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums) == 0:
            return 0
        
        maxVal = 0

        for i in range(len(nums)):
            maxVal = max(maxVal, nums[i])
        
        arr = [0 for i in range(maxVal + 1) ]

        for i in range(len(nums)):
            arr[nums[i]] += nums[i]
        
        prev = 0
        curr = 0

        for i in range(len(arr)):
            temp = max(curr, arr[i] + prev)
            prev = curr
            curr = temp

        return max(prev, curr)  
