# // Time Complexity : O(n^2)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


from typing import List
def minFallingPathSum(matrix: List[List[int]]) -> int:
    n = len(matrix)
    
    for i in range(n-2, -1, -1):
        for j in range(n):
            if j == 0:
                matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])

            elif j == n - 1:
                matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j])
            
            else:
                matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
                
    return min(matrix[0])


matrix = [[2,1,3],[6,5,4],[7,8,9]]

print(minFallingPathSum(matrix))