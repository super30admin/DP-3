# Time Complexity: O(n^2)
# Space Complexity:
# Is this problem on the leetcode: Yes
# Approach to solve the problem:
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for row in range(1, len(matrix)):           # skip the first row
            for col in range(len(matrix[0])):       # find min of the above element
                
                min_so_far = matrix[row-1][col]     # current min is the top element
                
                if col - 1 >= 0:
                    min_so_far = min(min_so_far, matrix[row-1][col-1])    # if top-left not out of bound
                if col + 1 < len(matrix[0]):
                    min_so_far = min(min_so_far, matrix[row-1][col+1]) # if top-right not out of bounds
                matrix[row][col] = matrix[row][col] + min_so_far
        return min(matrix[len(matrix)-1])