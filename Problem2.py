# Time Complexity :O(n*m) where n is rows and m is cols
# Space Complexity :O(1)
#  Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no
#Leetcode : 931

# Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
#
# A falling path starts at any element in the first row and chooses the element in the next row that is either
# directly below or diagonally left/right. Specifically, the next element from position (row, col) will be
#  (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

# Example 1:
#
# Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
# Output: 12
# Explanation: There are two falling paths with a minimum sum underlined below:
# [[2,1,3],      [[2,1,3],
#  [6,5,4],       [6,5,4],
#  [7,8,9]]       [7,8,9]]
# Example 2:
#
# Input: matrix = [[-19,57],[-40,-5]]
# Output: -59
# Explanation: The falling path with a minimum sum is underlined below:
# [[-19,57],
#  [-40,-5]]
# Example 3:
#
# Input: matrix = [[-48]]
# Output: -48


def main():
    matrix = [[2, 1, 3], [6, 5, 4], [7, 8, 9]]
    ans = minFallingPathSum(matrix)
    print(ans)
def minFallingPathSum(matrix):
    """
    :type matrix: List[List[int]]
    :rtype: int
    """
    # Similar to paint house problem.

    if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
        return 0

    # Here we again start from 1st row and not the 0th row. because we will gradually build the matrix along the way
    # We need to take care of 2 things here. That we can traverse atmost 1 block right up down or left and find the minimum falling path.
    # Second thing that we need to take care is bounds.

    for row in range(1, len(matrix)):
        for col in range(len(matrix[0])):
            # When we are in the first col we can only come from either top or top right.
            if col == 0:
                matrix[row][col] += min(matrix[row - 1][col], matrix[row - 1][col + 1])
                # When we are in the last col we can only come from top or top left
            elif col == len(matrix[0]) - 1:
                matrix[row][col] += min(matrix[row - 1][col], matrix[row - 1][col - 1])
                # Else we can come from all three spots.
            else:
                matrix[row][col] += min(matrix[row - 1][col], matrix[row - 1][col - 1], matrix[row - 1][col + 1])

    # Most optimal answer from final row.

    # Then we have all the optimal paths till last row. And then in last row, we return the minimum in last row.
    return min(matrix[-1])

if __name__ == '__main__':
    main()