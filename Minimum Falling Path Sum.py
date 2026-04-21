# Time Complexity --> O(n*n) where n*n are the dimensions of matrix
# Space Complexity --> O(n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        if n==1:
            return matrix[0][0]

        dp = [0 for i in range(n)]
        for i in range(n):
            left = 0
            for j in range(n):
                temp = dp[j]
                if j==0:
                    dp[j] = matrix[i][j] + min(dp[j], dp[j+1])
                elif j==n-1:
                    dp[j] = matrix[i][j] + min(left, dp[j])
                else:
                    dp[j] = matrix[i][j] + min(left, dp[j], dp[j+1])
                left = temp

        return min(dp)



'''
# Time Complexity --> O(n*n) where n*n are the dimensions of matrix
# Space Complexity --> O(n*n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        re = float('inf')
        n = len(matrix)
        self.memo = [[float('inf')]*(n) for i in range(n)]
        for i in range(n):
            re = min(re, self.helper(matrix, 0, i))
        return re 


    def helper(self, matrix, row, col):
        # base
        if row==len(matrix):
            return 0
        if self.memo[row][col]!=float('inf'):
            return self.memo[row][col]
        # logic
        if col==0:
            case = matrix[row][col] + min(self.helper(matrix, row+1, col), self.helper(matrix, row+1, col+1))
        elif col==len(matrix)-1:
            case = matrix[row][col] + min(self.helper(matrix, row+1, col-1), self.helper(matrix, row+1, col))
        else:
            case = matrix[row][col]+min(self.helper(matrix, row+1, col-1), self.helper(matrix, row+1, col), self.helper(matrix, row+1, col+1))
        self.memo[row][col] = case
        return case
'''
