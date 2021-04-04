# -*- coding: utf-8 -*-
"""
Created on Sun Apr  4 11:34:01 2021

@author: jgdch
"""

#Time Complexity, O(N) where N is the max of (len(nums),len(nums_maxarray))
#Space Complexity, O(N), where N is the len(nums_maxarray) which is maximum number in the input list

class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if(len(nums)==0):
         return 0
        max_nums=nums[0]
        for i in range(len(nums)):
            if(nums[i]>max_nums):
                max_nums=nums[i]
        nums_maxarray=[0]*(max_nums+1)
        for i in nums:
            nums_maxarray[i]+=i
        #print(nums_maxarray)
        take=nums_maxarray[0]
        skip=0
        
        for i in range(1,len(nums_maxarray)):
            #print(skip,take)
            temp=take
            take=skip+nums_maxarray[i]
            skip=max(temp,skip)
        return max(skip,take)
            
    
            
       
        
            
                
            
            
            
            
            