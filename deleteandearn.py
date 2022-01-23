
# // Time Complexity : O(N)
# // Space Complexity :O(N) +max(O(N))
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums== None : return 0
        
        maximum = 0 
        for i in range(len(nums)):
            maximum = max(maximum,nums[i])
        arr =[0 for i in range(maximum+1)]
        for i in range(len(nums)):
            arr[nums[i]]+= nums[i]
        # house robber logic
        skip =0
        take =0
        for i in range (1,len(arr)):
            temp = skip
            skip = max(skip,take)
            take =temp + arr[i]
        return max(skip, take)
            
        
        
        
            