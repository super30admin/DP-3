// Time Complexity :O(m*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution:
    def minFallingPathSum(self, matrix: list[list[int]]) -> int:
        for i in range(1,len(matrix)):
            matrix[i][0] += min(matrix[i-1][0],matrix[i-1][1])
            matrix[i][len(matrix[0])-1] += min(matrix[i-1][len(matrix[0])-1],matrix[i-1][len(matrix[0])-2])
            for j in range(1,len(matrix[0]) - 1):
                matrix[i][j] += min(matrix[i-1][j-1],matrix[i-1][j],matrix[i-1][j+1])
        return min(matrix[-1]) 