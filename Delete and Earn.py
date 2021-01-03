class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #Time Complexity: O(nums) 
        #Space Complexity: O(nums)
        
        if len(nums) == 0:
            return 0
        
        dp = [0 for i in range(max(nums) + 1)]
        dp[0] = 0
        dp[1] = 1 * nums.count(1)
        
        for i in range(2, len(dp)):
            dp[i] = max(dp[i-1], dp[i-2] + i * nums.count(i))
                        
        return dp[-1]