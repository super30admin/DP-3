'''
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        mat_dim = len(matrix)
        if mat_dim == 1:
            return matrix[0][0]
        _min = 10001
        _sol = matrix[mat_dim-1].copy()
        for i in range(mat_dim-2, -1, -1):
            temp = _sol.copy()
            for j in range(mat_dim):
                if j == 0:
                    temp[j] = matrix[i][j] + min(_sol[j], _sol[j+1])
                elif j == mat_dim-1:
                    temp[j] = matrix[i][j] + min(_sol[j], _sol[j-1])
                else:
                    temp[j] = matrix[i][j] + min(_sol[j-1], _sol[j], _sol[j+1])
                if i == 0:
                    if temp[j] < _min:
                        _min = temp[j]
            _sol = temp
            del temp
        return _min