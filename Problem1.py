#Problem 1 : https://leetcode.com/problems/delete-and-earn/
#Test Cases Passed on LeetCode
#Time Complexity-O(max(nums))=O(N)
#Space Complexity-O(max(nums))=O(N)

class Solution:
    def deleteAndEarn(self, nums):
        if not nums or len(nums)==0:
            return 0
        #find max so that we can create array 0-max
        m=max(nums)
        #lets 2 appeared twice in nums so earned value be 4 
        #if 1 does not appear even once the earned value would be 0
        earned=[0 for i in range(m+1)]
        for num in nums:
            earned[num]+=num
        #print(earned)
        dp=[[0 for j in range(2)] for i in range(m+1)]
        #same as house robber problem now
        for i in range (1,len(dp)):
            #not choosing 
            dp[i][0]=max(dp[i-1][0],dp[i-1][1])
            #choosing
            dp[i][1]=earned[i]+dp[i-1][0]
        return max(dp[m][0],dp[m][1])

sol=Solution()
nums = [3, 4, 2]
print(sol.deleteAndEarn(nums))













