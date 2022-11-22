# https://leetcode.com/problems/minimum-falling-path-sum/submissions/

# // Time Complexity : O(n*n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        minVal = sys.maxsize
        for i in range(1,n):
            for j in range(0,n):
                if j == 0:
                    diagleft = minVal
                else:
                    diagleft = matrix[i-1][j-1]
                top = matrix[i-1][j]
                if j!= n-1:
                    diagRight = matrix[i-1][j+1]
                else:
                    diagRight = minVal          
                matrix[i][j] += min(diagleft, min(diagRight, top))
        for i in range(0,n):
            minVal = min(minVal, matrix[n-1][i])
                
        return minVal