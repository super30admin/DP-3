class Solution:
    
    def __init__(self):
        self.delEarnList = None
    
    def getMaxEarn(self,index):
        
        #base case
        if index >= len(self.delEarnList):
            return 0
        
        # actual logic
        # Case 1: ignore index
        case1 = self.getMaxEarn(index+1)
        
        # Case 2: select index
        case2 = self.delEarnList[index] + (self.getMaxEarn(index+2))
        
        # Return the max of case1 and case2
        return max(case1,case2)
    
    def fillUp(self,nums):
        
        # Find the max
        ele = max(nums)+1
        
        # Initialize a list delEarnList of size ele
        self.delEarnList = [0]*ele
        
        # Iterate the nums list and fill-up the count
        for index in range(0,len(nums)):
            getNumber = nums[index]
            self.delEarnList[getNumber] += getNumber
        
    
    def getSolution(self,nums):
        self.fillUp(nums)
        
        return self.getMaxEarn(0)

sol = Solution()
print(sol.getSolution([2,2,3,3,3,4]))