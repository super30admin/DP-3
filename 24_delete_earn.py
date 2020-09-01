# S30 Big N Problem #24 {Medium}
# Leetcode #740

# For an array nums of integers, For each iteration, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 and nums[i] + 1.
# You start with 0 points. Return the maximum number of points you can earn.

# Time Complexity : O(n) n= max element of array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        dp=[0 for _ in range(max(nums)+1)]
        
        print(dp)
        
        for i in nums:
            dp[i]=dp[i]+i
        
        arr=[[0 for _ in range(2) ]for _ in range(max(nums)+1)]
        
        print(arr)
        for i in range(1,len(arr),1):
            
            arr[i][0]=dp[i]+arr[i-1][1]
            arr[i][1]=max(arr[i-1][0],arr[i-1][1])
            
        
        
        return max(arr[len(arr)-1])
            
            
        
            
            
            