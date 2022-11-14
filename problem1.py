#create an array where the index is the element and value will be frequency*element.
#From here on, we can store the solution for 2 options. 1st option will be not pick the current #element and the current solution will be the maximum of previous 2 options. If the current element 
# has is picked, then the not picked solution of the previosu subproblem has to be added with the #cuurent element. Finally, return the max of those 2 options.
class Solution:
    def deleteAndEarn(self, nums) -> int:
        dp=[]
        m=max(nums)
        for i in range(m+1):
            dp.append(0)

        for i in nums:
            dp[i]+=i
        skip=0
        take=dp[0]
        for i in range(1,len(dp)):
            temp=skip
            skip=max(skip,take)
            take=temp+dp[i]
        return max(take,skip)
s=Solution()
nums=[2,2,3,3,3,4]
print(s.deleteAndEarn(nums))
