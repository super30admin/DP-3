'''
Space Complexity: O(n)+O(n)=O(2n)
Time Complexity: O(n)

Approach: Notice how it is similar to House robber, therefore we create a new 
array and store the sums for each value in nums
for eg: [2,2]=4
After we have now reduced it to house robber, so we can apply house robber logic
to it.
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums: 
            return 0
        sums_nums = [0] * (max(nums)+1)
        for num in nums:
            sums_nums[num] += num
        
        dp = [0]*(len(sums_nums)+1)
        for i in range(1,len(sums_nums)):
            dp[i] = max(sums_nums[i]+dp[i-2], dp[i-1])
        return max(dp[-1],dp[-2])
        