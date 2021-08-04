#Leetcode problem 740
#Similar to house robber problem
class Solution:
    def deleteAndEarn(self, nums):
        res=[0]*(max(nums)+1)
        for i in range(len(nums)):
            res[nums[i]]+=nums[i]
            
        zeroind=0
        oneind=0
        for i in range(len(res)):
            temp=zeroind
            zeroind=max(oneind,zeroind)
            oneind=temp+res[i]
        return max(zeroind,oneind)

#TC: O(maxNumber)
#SC: O(maxNumber)