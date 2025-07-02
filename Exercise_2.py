# Time Complexity: O(m * n)
# Space Complexity: O(1)
# Were you able to run the code on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:

        m = len(matrix)
        n = len(matrix[0])

        # dp = [[ 0 for j in range(n)]  for i in range(m) ]
        
        # Assuming we allowed to modify the input matrix, we can use it as our dp array
        for i in range(m-2, -1, -1):    
            
            # Start from the second last row and move upwards
            # We will update the current row based on the values from the row below it
            
            for j in range(n):
            
                if j > 0 and j < n-1:
                    matrix[i][j] = min( matrix[i+1][j-1] , matrix[i+1][j], matrix[i+1][j+1]  ) + matrix[i][j]
                elif j == 0:
                    matrix[i][j] = min( matrix[i+1][j], matrix[i+1][j+1] ) + matrix[i][j]
                elif j == n-1:
                    matrix[i][j] = min( matrix[i+1][j], matrix[i+1][j-1] ) + matrix[i][j]

        return min(matrix[0])