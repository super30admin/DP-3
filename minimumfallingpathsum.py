class Solution:
    def minFallingPathSum(self, nums: List[List[int]]) -> int:
        '''
        TC : O(m*n)
        SC : O(1)
        Approach :  dynamic progarming 
        dp[i][j] = dp[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])
        
        '''
        
        n = len(nums)
        m = len(nums[0])

        for i in range(1,n):
            for j in range(m):
                if j == 0:
                    nums[i][j] += min(nums[i-1][j],nums[i-1][j+1])
                elif j == m-1:
                    nums[i][j] += min(nums[i-1][j],nums[i-1][j-1])
                else:
                    nums[i][j] += min(nums[i-1][j], nums[i-1][j-1],nums[i-1][j+1])
        return min(nums[-1])