
"""
TC = O(n*n)
SC =O(1)

"""

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        for row in range(1, len(matrix)):
            for col in range(len(matrix[0])):
            # we add the min of upper 3 elements to the curr element in the matrix
            
                matrix[row][col]= matrix[row][col]+\
                min(matrix[row-1][col], \
                matrix[row-1][col-1] if col-1>=0 else float('inf'),\
                matrix[row-1][col+1]if col+1<len(matrix[0]) else float('inf'))
        #return the min of the last row
        return min(matrix[-1])  
    
