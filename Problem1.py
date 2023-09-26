'''
1. We see the problem as to whether we choose a number or not. If we choose one, we cannot take the previous and next ones.
2. We maintain a dp array that has the points that are obtained by choosing a number at index "number". 
3. 2 conditions:
a. If we skip a number, it is equivalent to taking the maximum obtained by either skipping/taking the previous number. 
b. If we decide to take it, we are definitely skipping the previous one. So we add the current number to the maximum obtained by skipping the previous number.
'''

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == None or len(nums)==0:
            return 0
        
        Max = 0

        for i in range(len(nums)):
            if nums[i] > Max:
                Max = nums[i]
            
        dp = [0 for _ in range(Max + 1)]

        for i in range(len(nums)):
            idx = nums[i]
            dp[idx] += nums[i]
        
        skip, take = 0,0
        for i in range(1,Max+1):
            temp = skip
            skip = max(skip,take)
            take = dp[i] + temp
        
        return max(skip,take)