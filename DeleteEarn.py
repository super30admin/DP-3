# Time Complexity : It is O(N) since looping through the list.
# Space Complexity : It is O(N) since we are creating a new list.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

from typing import List

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        maxlength=0

        for i in range(len(nums)):
            maxlength = max(maxlength,nums[i])
            
        orderNums = [0]* (maxlength+1)
        
        for i in range(len(nums)):
            orderNums[nums[i]] += nums[i]
        
        dp =[0]* (len(orderNums))            
        previousAmount=0
        currentamount=0
        dp[0]= orderNums[0]
        dp[1]= max(orderNums[0],orderNums[1])
        
        
        for i in range(2,len(orderNums)):
            previousAmount=dp[i-1]
            currentamount=orderNums[i] + dp[i-2]
            dp[i]=max(previousAmount,currentamount)
        
        return dp[-1]
    
obj = Solution()
print(obj.deleteAndEarn([3,4,2]))
print(obj.deleteAndEarn([2,2,3,3,3,4]))