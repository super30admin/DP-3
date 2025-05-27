from collections import Counter

class Solution:
    def deleteAndEarn(self,nums):
        if not nums:
            return 0
        
        points=Counter()
        for num in nums:
            points[num]+=num

        max_num=max(points)
        dp=[0]*(max_num+1)

        dp[0]=0
        dp[1]=points[1]

        for i in range(2,max_num+1):
            dp[i]=max(dp[i-1],dp[i-2]+points[i])

        return dp[max_num]
    
sol=Solution()
print(sol.deleteAndEarn(nums=[3,4,2]))
print(sol.deleteAndEarn(nums=[2,2,3,3,3,4]))
