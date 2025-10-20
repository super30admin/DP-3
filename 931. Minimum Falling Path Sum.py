# EXHAUSTIVE SOLUTION
# Time: O(3^n) 3 choices at everypoint
# Space: O(n) recursion stack will go as deep as rows

# Choose every 3 options at a given point
# To start loop through the first row and then call the function inside the loop 
# The function makes 3 choices for a given item and return the min of it by adding the used element
# The base cases should be to check if col index goes out of range which is invalid or if row index is at the end in that case we have to return the value itself
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        temp = float('inf')
        for j in range(len(matrix)):
            temp = min(temp,self.helper(0,j,matrix))
        return temp
    def helper(self,i,j,matrix):
        # Base case
        if j > len(matrix) - 1 or j < 0:
            return float('inf')
        if i == len(matrix) - 1:
            return matrix[i][j]

        # Choose 3 different paths
        left = self.helper(i + 1, j - 1, matrix)
        right = self.helper(i + 1, j + 1, matrix)
        down = self.helper(i + 1, j, matrix)

        return matrix[i][j] + min(left, right, down)
    
# MEMOISATION APPROACH
# Time: O(n^2) because it's a square matrix and we are exploring every element in the matrix so it's (m*n).
# Space: O(n^2) + O(n) n^2 for a matrix and n for the recursion stack
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        temp = float('inf')
        self.memo = [[101 for _ in range(len(matrix))] for _ in range(len(matrix[0])) ]
        for j in range(len(matrix[0])):
            temp = min(temp,self.helper(0,j,matrix))
        return temp
    def helper(self,i,j,matrix):
        # Base case
        if j > len(matrix) - 1 or j < 0:
            return float('inf')
        if i == len(matrix) - 1:
            return matrix[i][j]
        if self.memo[i][j] != 101:
            return self.memo[i][j]

        # Choose 3 different paths
        left = self.helper(i + 1, j - 1, matrix)
        right = self.helper(i + 1, j + 1, matrix)
        down = self.helper(i + 1, j, matrix)

        self.memo[i][j] = matrix[i][j] + min(left, right, down)
        return self.memo[i][j]
    
# TABULATION WITH SPACE OPTIMISATION
# Time: O(n^2)
# Space: O(n) Just store 1 array that we need and keep on calculating on it

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp = matrix[-1][:]
        for i in range(len(dp)-2, -1, -1):
            temp = [0] * len(dp)
            for j in range(len(temp)):
                if j == 0:
                    temp[j] = matrix[i][j] + min(dp[j],dp[j+1])
                elif j == len(dp) - 1:
                    temp[j] = matrix[i][j] + min(dp[j],dp[j-1])
                else:
                    temp[j] = matrix[i][j] + min(dp[j],dp[j-1],dp[j+1])
            dp = temp

        return min(dp)