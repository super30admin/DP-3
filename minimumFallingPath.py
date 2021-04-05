"""
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either 
directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), 
(row + 1, col), or (row + 1, col + 1).

Example 1:

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum underlined below:
    1 + 4 + 8
"""
"""
dynamic approach modify the existing in 2D array from top to bottom
add minimum of the elements directly above the current element

return the minimum of the last row elemets

time complexity - O(m*n)
space complexity - O(1)
"""

def minFallingPathSum(matrix):
    for i in range(1, len(matrix)):
        for j in range(len(matrix[i])):
            if(j == 0):
                matrix[i][j] = matrix[i][j] + min(matrix[i-1][j], matrix[i-1][j+1])
            elif(j == len(matrix[i])-1):
                matrix[i][j] = matrix[i][j] + min(matrix[i-1][j], matrix[i-1][j-1])
            else:
                matrix[i][j] = matrix[i][j] + min(matrix[i-1][j], min(matrix[i-1][j-1], matrix[i-1][j+1]))

    return min(matrix[-1])


print(minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]]))
print(minFallingPathSum([[-19,57],[-40,-5]]))