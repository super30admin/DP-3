#time complexity:O(n) where n is max(len(nums),maxvalue) since dp array goes to maxvalue
#space complexity:o(n), where n is based on max value
#passed all cases on LeetCode:yes
#difficulty faced:
# comments: in the code
#https://leetcode.com/problems/delete-and-earn/submissions/
import sys
class Solution:
    def deleteAndEarn(self, nums: 'List[int]') -> int:
        if nums == None or len(nums) == 0: return 0
        
        #inorder to form dp array, need to find the max value for creating dp array
        max1 = -sys.maxsize -1
        for i in range(len(nums)):
            max1 = max(max1,nums[i])
            
        #if nums is [3,4,2] dp array is [0,0,2,3,4]
        dp = [0 for i in range(max1+1)]
        
        for i in range(len(nums)):
                dp[nums[i]] += nums[i]
          
        skip = 0
        take = dp[0]
        
        #after forming dp array above this is a houserobber type problem 
        #where we either take or skip that 
        for i in range(1,max1+1):
            
            temp = skip
            skip = max(skip,take)
            take = temp + dp[i]
        
        return max(skip,take)
    
    