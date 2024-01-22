// Delete and Earn

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        max_num = max(nums)

        points = [0] * (max_num+1)
        for num in nums:
            points[num] += num

        dp = [0] * (max_num+1)
        dp[1] = points[1]

        for i in range(2,max_num+1):
            dp[i] = max(dp[i-1], dp[i-2]+points[i])

        return dp[max_num]

//  Minimum Falling Path Sum
// Time Complexity : O(mn)
// Space Complexity : O(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        n = len(matrix[0])
        min_path_sum = 0
        if m==0: return 0
        for i in range(1,m):
            for j in range(n):
                aboveSum = matrix[i-1][j]
                aboveRSum = matrix[i-1][j+1] if(j<n-1) else float(inf)
                aboveLSum = matrix[i-1][j-1] if(j>0) else float(inf)
                matrix[i][j] += min(aboveSum, aboveRSum, aboveLSum)
        return min(matrix[m-1])



  
