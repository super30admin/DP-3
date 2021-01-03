class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        #Time Complexity: O(nums) 
        #Space Complexity: O(nums)
        
        if len(nums) == 0:
            return 0
        
        count_map = {}
        for num in nums:
            count_map[num] = count_map.get(num, 0) + 1
        
        dp = [0 for i in range(max(nums) + 1)]
        dp[0] = 0
        dp[1] = 1 * count_map.get(1, 0)
        
        for i in range(2, len(dp)):
            dp[i] = max(dp[i-1], dp[i-2] + i * count_map.get(i, 0))
                        
        return dp[-1]