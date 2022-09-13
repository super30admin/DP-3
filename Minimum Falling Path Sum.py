# Time Complexity : O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Please provide solution for better understanding


# Your code here along with comments explaining your approach
# Time:  O(n^2)
# Space: O(1)
import math


def minFallingPathSum(matrix) -> int:
    n = len(matrix)
    res = list(matrix[n - 1])
    for r in range(n - 2, -1, -1):
        new_res = [0] * n
        for c in range(0, n):
            if c == 0:
                new_res[c] = matrix[r][c] + min(res[c], res[c + 1])
            elif c == n-1:
                new_res[c] = matrix[r][c] + min(res[c], res[c - 1])
            else:
                new_res[c] = matrix[r][c] + min(res[c], res[c + 1], res[c - 1])
        res = new_res
                
    return min(res)

def minFallingPathSum1(matrix) -> int:
    n = len(matrix)
    
    for i in range(1,n):
        for j in range(n):
            mini = math.inf
            for k in range(max(0, j-1), min(n,j+2)):
                mini = min(mini,matrix[i-1][k])
            matrix[i][j] += mini
            
    return min(matrix[-1])

matrix = [[2,1,3],[6,5,4],[7,8,9]]
print(minFallingPathSum(matrix))
print(minFallingPathSum1(matrix))