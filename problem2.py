# probleme.py
# https://leetcode.com/problems/minimum-falling-path-sum/

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        m = len(matrix)
        for i in range(m-2,-1,-1):
            for j in range(m):
                l_val = float('inf')
                m_val = float('inf')
                r_val = float('inf')
                # find l_val 
                if j-1 >= 0:
                    l_val = matrix[i+1][j-1]
                m_val = matrix[i+1][j]
                if j+1 < m:
                    r_val = matrix[i+1][j+1]
                matrix[i][j] += min(l_val,m_val,r_val)
        return min(matrix[0])