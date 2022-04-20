class Solution:
    def rob(self, nums: List[int]) -> int:               
        
        if len(nums)==1: return nums[0]
        if len(nums)==2: return  max(nums[0], nums[1])

        back_2 = 0
        back_1 = 0
        
        for i in range(len(nums)):
            tmp = nums[i] + back_2 
            if tmp > back_1:
                new_back1 = tmp
            else :
                new_back1 = max(back_1, back_2)
                
            back_2 = back_1
            back_1 = new_back1

        return new_back1