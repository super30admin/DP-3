# // Time Complexity :O(n)
# // Space Complexity :O(n)
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        limit=max(nums)
        dp=[0 for i in range(limit+1)]
        for i in range(len(nums)):
            dp[nums[i]]+=1
        skip=0
        take=0
        print(dp)
        for i in range(limit+1):
            print(skip,take)
            temp=skip
            skip=max(temp,take)
            take=temp+dp[i]*i
        return max(skip,take)
        