import numpy as np
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        hm = [0] + [0]*max(nums)
        for num in nums:
            hm[num] += num
        
        C = 0
        DC = 0
        
        for val in hm:
            temp = max(DC,C)
            C = val + DC
            DC = temp
        return int(max(C,DC))
        
#         if len(nums) == 1:   #This is giving time limit exceed
#             return int(nums[0])
#         self.final = 0
#         bank = {}
#         def chor(i,kamai):
            
#             kamai += nums[i]
#             if i not in bank.keys():
#                 bank[i] = kamai
#             elif bank[i] < kamai:
#                 bank[i] = kamai
#             else:
#                 return
#             if i == len(nums)-1 or i == len(nums)-2:
                
#                 self.final = max(self.final,kamai)
#                 return
            
#             for j in range(i+2,len(nums)):
#                 chor(j,kamai)
#         chor(0,0)
#         chor(1,0)
            
        # return int(self.final)