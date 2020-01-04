# -*- coding: utf-8 -*-
"""
Created on Sat Jan  4 17:28:22 2020

@author: WELCOME
"""
"""
Time Complexity = O(N) where N is max(nums)
Space Complexity = O(M) where M is number of unique elements in nums
""" 

class Solution:
    def deleteAndEarn(self, nums):
        if nums==None or len(nums)==0:
            return 0
        dic={}
        notchoose=0
        choose=0
        for i in nums:
            if i not in dic:
                dic[i]=i
            else:
                dic[i]+=i
        for i in range(1,max(nums)+1):
            if i in dic:
                if i-1 not in dic:
                    notchoose=max(choose,notchoose)
                    choose=max(choose,notchoose)+dic[i]
                else:
                    temp=choose
                    choose=notchoose + dic[i]
                    notchoose=max(temp,notchoose)
        return max(choose,notchoose)
    
temp=Solution()
print(temp.deleteAndEarn([1,2,3,4,4,4]))
    