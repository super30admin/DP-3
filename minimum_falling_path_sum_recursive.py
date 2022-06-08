# Time Complexity : O(O(N * 3^N)) where where N is number of rows in the matrix
# Space Complexity : O(N) where N is number of rows in the matrix
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.minimum = float('inf')
        self.dirs = [[1,1], [1, 0], [1, -1]]
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for i in range(len(matrix[0])):
            self.matrixExplorer(matrix, 0, i, 0)
        return self.minimum
            
    def matrixExplorer(self, matrix, r, c, currSum):
        #base
        if r == len(matrix):
            if currSum < self.minimum:
                self.minimum = currSum
            return
        
        #logic
        for d in self.dirs:
            nr = r + d[0]
            nc = c + d[1]
            if nc >= 0 and nc < len(matrix[0]):
                self.matrixExplorer(matrix, nr , nc , currSum + matrix[r][c])