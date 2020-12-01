'''
Time complexity :O(N)
Space complexity :O(1)
'''


class Solution:
    def deleteAndEarn(self, nums) -> int:
        if not nums:
            return 0
        
        maximum = float('-inf')
        for i in range(len(nums)):
            if nums[i] > maximum:
                maximum = nums[i]
                
        dp = [0] * (maximum+1)
        
        for num in nums:
            dp[num]+= num
            
        skip,take =0,0
        for i in range(len(dp)):
            temp = max(skip,take)
            take = skip + dp[i]
            skip = temp
        return max(skip,take)

s = Solution()
print(s.deleteAndEarn([2, 2, 3, 3, 3, 4]))