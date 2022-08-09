# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


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


if __name__ == '__main__':
    _mat = [[2, 1, 3], [6, 5, 4], [7, 8, 9]]

    print(Solution().minFallingPathSum(_mat))
