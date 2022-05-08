class Solution:
    
    def __init__(self):
        self.delEarnList = None
        self.earnList = None
        
    def getMaxEarn(self,index):
        
        for index in range(len(self.earnList)-1,-1,-1):
            
            #Case1: ignore index
            case1 = 0
            if index+1<len(self.earnList):
                case1 = self.earnList[index+1]
            
            # Case 2: accept index
            case2 = self.delEarnList[index]
            if index+2 < len(self.earnList):
                case2 += self.earnList[index+2]
            
            self.earnList[index] = max(case1,case2) 
        
        return self.earnList[0]
        
    def fillUp(self,nums):
        
        # Find the max
        ele = max(nums)+1
        
        # Initialize a list delEarnList of size ele
        self.delEarnList = [0]*ele
        self.earnList = [None]*ele
        
        # Iterate the nums list and fill-up the count
        for index in range(0,len(nums)):
            getNumber = nums[index]
            self.delEarnList[getNumber] += getNumber
        
    
    def getSolution(self,nums):
        self.fillUp(nums)
        
        return self.getMaxEarn(len(self.delEarnList)-1)

sol = Solution()
print(sol.getSolution([2,2,3,3,3,4]))