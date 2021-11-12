# 931. Minimum Falling Path Sum
# https://leetcode.com/problems/minimum-falling-path-sum/

# Efficient Solution: DP

# Logic: Start from the last row and fill dp's last row with the same. 
# Take a window of 3 elements (neighbours that are possible) and find 
# min in the window and add to the element in the current row col.

# Time complexiety: O(n*m)
# Space complexiety: O(n*m)

class Solution:
    def minFallingPathSum(self, matrix) -> int:            
        n = len(matrix)
        m = len(matrix[0])
        
        dp = [[0 for j in range(m)] for i in range(n)]
        
        i = n - 1
        j = m - 1
        
        while j != -1:
            dp[i][j] = matrix[i][j]
            j -= 1
            
        for i in range(n-2,-1,-1):
            for j in range(m):
                if j == 0:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j],dp[i+1][j+1])
                elif j == m-1:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j],dp[i+1][j-1])
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i+1][j-1],dp[i+1][j],dp[i+1][j+1])
        
        return min(dp[0])


# Inefficient Solution: DFS
class Solution:
    def minFallingPathSum(self, matrix) -> int:
        stack = []
        minSum = float("inf")
        dirs = [(1,0),(1,1),(1,-1)]
        
        n = len(matrix)
        m = len(matrix[0])
        
        for i in range(m):
            curSum = 0
            stack.append((matrix[0][i],curSum,0))

            while stack:
                val, curSum, idx = stack.pop()
                curSum += val
                
                if idx == m-1:
                    minSum = min(minSum,curSum)        
                else:
                    for _dir in dirs:
                        newRow = idx + _dir[0]
                        newCol = i + _dir[1]
                        
                        if 0 <= newRow < n and 0 <= newCol < m:
                            stack.append((matrix[newRow][newCol],curSum,idx+1))
        return minSum

obj = Solution()
print(obj.minFallingPathSum([[-19,57],[-40,-5]]))
print(obj.minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]]))