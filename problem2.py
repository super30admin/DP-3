'''
931. Minimum Falling Path Sum

TIME COMPLEXITY: O(N2)
SPACE COMPLEXITY: O(N)
LEETCODE: YES
DIFFICULTIES: NO, it is similar to "paint house" problem
'''


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rl = cl = len(matrix)
        
        
        for i in range(0, rl-1):
            mxv = [(2 ** 31) for i in range(0, cl)]
            for j in range(0, cl):
                for k in range( max(j-1,0), min(cl, j+2) ):
                    a = matrix[i][j] + matrix[i+1][k]
                    if a < mxv[k]:
                        mxv[k] = a
                    
            matrix[i+1] = mxv
        
        return min(matrix[rl-1])
            
