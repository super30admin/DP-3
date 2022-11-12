class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        ## m = max value in nums list
        ## TC = O(n) + O(m)
        ## SC = 1
        
        tmp = [0]*(max(nums) + 1)
        
        for i in range(len(nums)):
            tmp[nums[i]] += nums[i]
        
        skip, rob = 0, tmp[0]
        
        for i in range(1, len(tmp)):
            
            prev_skip = skip
            skip = max(skip, rob)
            rob = tmp[i] + prev_skip
        
        return max(skip, rob)