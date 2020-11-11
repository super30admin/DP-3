# Dynamic Programming
# passed all test cases
# time complexity =O(n)
#space complexity=O(1)
class Solution(object):
    def deleteAndEarn(self, nums):
        if nums ==[]:
            return 0
        self.b= [0] * (max(nums)+1)
        for i in nums:
            self.b[i] += i
        #dp=[[[0] for j in range(2) ]for i in range(max(nums) + 1) ]
        self.skip=0
        self.take=0
        for i in range(1,len(self.b)):
            self.skip,self.take = max(self.skip,self.take),self.b[i] + self.skip
            #since in python simlutanoeus update happens, the skip value is the value we got fro pprevious loop and both the variables are updated by previous value only
        return max(self.skip,self.take)