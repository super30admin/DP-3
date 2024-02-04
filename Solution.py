class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        [2,2,3,3,3,4]
        [0, 0, 4, 9, 4]
        2: 4
        3: 9
        4: 4
        n = len(nums)
        m = max(nums)
        time: O(max(m, n))
        space: O(m)
        """
        dp = [0] * (max(nums) + 1)
        for n in nums:
            dp[n] += n
        for i in range(2, len(dp)):
            dp[i] = max(dp[i-2] + dp[i], dp[i-1])
        return dp[-1]

    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        n = len(matrix)
        m = len(matrix[0])
        time = O(n*m)
        space = O(1) if we do not consider space taken by the input
        """
        for i in range(1, len(matrix)):
            for j in range(len(matrix[0])):
                min_prev = matrix[i-1][j]
                if j != 0 and j != len(matrix[0]) - 1:
                    min_prev = min(matrix[i-1][j], matrix[i-1][j-1], matrix[i-1][j+1])
                elif j == 0:
                    min_prev = min(matrix[i-1][j], matrix[i-1][j+1])
                else:
                    min_prev = min(matrix[i-1][j-1], matrix[i-1][j])
                matrix[i][j] = matrix[i][j] + min_prev
        return min(matrix[-1]) 
        