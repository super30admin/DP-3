'''
time complexity: O(n)
space complexity: O(1)
'''
class Solution:
    def rob(self, nums: List[int]) -> int:
        if(len(nums)==0): return 0
        if(len(nums)==1):return nums[0]
        
        #ns = [0 for _ in range(len(nums))]
        #ans[0] = nums[0]
        c1 = nums[0]
        #ans[1] = max(nums[0],nums[1])
        c2 = max(nums[0],nums[1])
        for i in range(2,len(nums)):
            temp = c1
            c1 = max(temp,c2)
            c2 = temp + nums[i]
            
        return max(c1,c2)