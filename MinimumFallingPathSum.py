# TC: O(n^2)
# SC: O(1)
# LeetCode: Y(https://leetcode.com/problems/minimum-falling-path-sum/)
# Approach: Convert recursive overlapping optimizing problem into dp
#           Start from 2nd row and store each minimum sum at each value in the matrix
#           Return the min of last row

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        
        if not matrix or not(len(matrix)):
            return 0
        
        # loop from 2nd row
        for row in range(1, len(matrix)):
            for col in range(len(matrix[row])):
                # skip left diagonal element for first element of row
                if col == 0:
                    matrix[row][col] += min(matrix[row - 1][col], matrix[row - 1][col + 1])
                # skip right diagonal element for last element of row
                elif col == len(matrix[row]) - 1:
                    matrix[row][col] += min(matrix[row - 1][col], matrix[row - 1][col - 1])
                # take min of three options for middle elements
                else:
                    matrix[row][col] += min(matrix[row - 1][col], min(matrix[row - 1][col - 1], matrix[row - 1][col + 1]))
                    
        return min(matrix[-1])
                    
