#----------------------------RECURSIVE SOLUTION--------------
#Time Complexity: O( M * 3 POW(N)) N is no.of rows and M is no.of columns
#Space Complexity: O(M)

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        col = len(matrix[0])
        min_res = float('inf')
        for i in range(col):
            min_res = min(min_res, self.helper(matrix,0,i))
        return min_res

    def helper(self,matrix,row,col):

        #Base1: column out of bounds
        if col < 0 or col >= len(matrix[0]):
            return float("inf")
        #Base 2: at the last row

        if row == len(matrix) - 1:
            return matrix[row][col]
        
        path1 = matrix[row][col] + self.helper(matrix,row + 1, col - 1)
        path2 = matrix[row][col] + self.helper(matrix,row + 1, col)
        path3 = matrix[row][col] + self.helper(matrix,row + 1, col + 1)

        return min(path1,path2,path3)
    
#-------------------------------MEMOIZATION------------------------
#Time Complexity: O(M * N)
#Space Complexity: O(M * N)

class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """ 
        n = len(matrix)
        m = len(matrix[0])
        memo = [[-1 for _ in range(m)] for _ in range(n)]
        col = len(matrix[0])
        min_res = float('inf')
        for i in range(col):
            min_res = min(min_res, self.helper(memo,matrix,0,i))
        return min_res

    def helper(self,memo,matrix,row,col):

        #Base1: column out of bounds
        if col < 0 or col >= len(matrix[0]):
            return float("inf")
        
        #Base 2: at the last row
        if row == len(matrix) - 1:
            return matrix[row][col]
        
        if memo[row][col] != -1:
            return memo[row][col]
        
        path1 = matrix[row][col] + self.helper(memo,matrix,row + 1, col - 1) 
        path2 = matrix[row][col] + self.helper(memo,matrix,row + 1, col)
        path3 = matrix[row][col] + self.helper(memo,matrix,row + 1, col + 1) 
        memo[row][col] = min(path1,path2,path3)

        return memo[row][col]
    

        
#----------------------------------TABULATION-------------------------

#Time Complexity: O(M * N)
#Space Complexity: O(M * N)
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """ 
        n = len(matrix)
        # Create a DP table with the same dimensions as matrix
        dp = [[0] * n for _ in range(n)]

        # Initialize the last row with matrix values
        for col in range(n):
            dp[n - 1][col] = matrix[n - 1][col]

        # Fill the DP table from bottom to top
        for row in range(n - 2, -1, -1):
            for col in range(n):
                down = dp[row + 1][col]
                left = dp[row + 1][col - 1] if col > 0 else float('inf')
                right = dp[row + 1][col + 1] if col < n - 1 else float('inf')
                dp[row][col] = matrix[row][col] + min(down, left, right)

    
        return min(dp[0])


#--------------------------SPACE OPTIMIZED------------------------------------------
#Time Complexity: O(M * N)
#Space Complexity: O(N)
class Solution(object):
    def minFallingPathSum(self, matrix):
        n = len(matrix)
        prev = matrix[n - 1][:]  # Start with last row

        for row in range(n - 2, -1, -1):
            curr = [0] * n
            for col in range(n):
                down = prev[col]
                left = prev[col - 1] if col > 0 else float('inf')
                right = prev[col + 1] if col < n - 1 else float('inf')
                curr[col] = matrix[row][col] + min(down, left, right)
            prev = curr  # Update for next iteration

        return min(prev)
