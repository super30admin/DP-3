'''

## Problem 931: Minimum Falling Path Sum

## Author: Neha Doiphode
## Date:   07-07-2022

## Description:
    Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
    A falling path starts at any element in the first row and
    chooses the element in the next row that is either directly below or diagonally left/right.
    Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

## Examples:
    Example 1:
        Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
        Output: 13
        Explanation: There are two falling paths with a minimum sum as shown.
                     2 1 3
                     6 5 4
                     7 8 9

                     Falling path 1 with minimum sum: 1 -> 5 -> 7 = 13
                     Falling path 2 with minimum sum: 1 -> 4 -> 8 = 13

    Example 2:
        Input: matrix = [[-19,57],[-40,-5]]
        Output: -59
        Explanation: The falling path with a minimum sum is shown.
                     -19 57
                     -40 -5

                     Falling path with minimum sum: -19 + -40 = -59

## Constraints:
    n == matrix.length == matrix[i].length
    1 <= n <= 100
    -100 <= matrix[i][j] <= 100


## Time complexity: Please refer to respective doc-strings of the approaches used below.

## Space complexity: Please refer to respective doc-strings of the approaches used below.

'''

from typing import List

def get_input():
    print("Enter the number of rows in the matrix: ", end = "")
    rows = int(input())
    print("Enter the number of columns in the matrix: ", end = "")
    columns = int(input())
    input_matrix = []
    print("Hit ENTER key after every element of the row.")
    for row in range(rows):
        l = []
        print(f"Row {row + 1}: ")
        for column in range(columns):
            inp = int(input())
            l.append(inp)
        input_matrix.append(l)

    return input_matrix

class Solution:
    def minFallingPathSum_brute_force(self, matrix: List[List[int]]) -> int:
        '''
        Time complexity: O(N * 3^N), 3-ary recursion based solution.
                                     N represents number of columns as we need to repeat the process of recursion over each column.
                                     Time complexity for actual recursion, can be split as follows:
                                        - Depth of recursion stack for each node depends on number of rows.
                                        - So, at row 0, there would be 3 nodes on the stack. At row 1, there would be 3^1(row) nodes and so on.
                                     Hence, 3^N for each node per column.
                                     Since there are N such columns we can say, it is O(N * 3^N).

        Space complexity: O(N), Max depth of given matrix is number of rows/length of matrix which is N.
                                At a time, we will not have more than N calls onto the recursion stack.
        '''
        minFallingSum = float("inf")

        for startCol in range(len(matrix)):
            minFallingSum = min(minFallingSum, self.findMinFallingPathSum_helper(matrix, 0, startCol))
        return minFallingSum;


    def findMinFallingPathSum_helper(self, matrix: List[List[int]], row : int, col : int) -> int:
        # base conditions
        # check if we are out of the left or right boundary of the matrix
        if (col < 0 or col == len(matrix)):
            return float("inf")

        # check if we have reached the last row
        if (row == len(matrix) - 1):
            return matrix[row][col]

        # calculate the minimum falling path sum starting from each possible next step
        #print("Recursive call before middle")
        middle = self.findMinFallingPathSum_helper(matrix, row + 1, col);
        #print(f"Middle: Row = {row}, Column = {col}: middle = {middle}")

        #print("Recursive call before right")
        right  = self.findMinFallingPathSum_helper(matrix, row + 1, col + 1)
        #print(f"Right: Row = {row}, Column = {col}: right = {right}")

        #print("Recursive call before left")
        left   = self.findMinFallingPathSum_helper(matrix, row + 1, col - 1)
        #print(f"Left: Row = {row}, Column = {col}: left = {left}")

        #print(f"Returning Min sum: left = {left}, right = {right}, middle = {middle}, row = {row}, col = {col} min sum = {min(left, min(middle, right)) + matrix[row][col]}")
        return min(left, min(middle, right)) + matrix[row][col]


    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        '''
        Time complexity: O(N^2), where N is length of matrix, to calculate bottom-up sum at each level or row.

        Space complexity: O(1), since we are using same input matrix to calculate sum of falling paths.
        '''
        if len(matrix) == 0:
            return 0

        min_sum = float("inf")
        n = len(matrix) # number of rows

        # we are doing bottom up dynamic programming
        # So we start from n - 2th row (second last)
        # then, move towards row 0 finding all possible sums
        # we are using same input matrix and not using any extra space.
        # In case we are not allowed to modify input matrix, we will have to construct dp array

        # Trace rows from bottom to top
        for i in range(n - 2, -1, -1):
            # Trace columns from left to right
            for j in range(n):
                # If we are in the first column
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])

                # If we are in the last column
                elif j == n - 1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])

                # Trace all middle columns
                else:
                    matrix[i][j] += min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])

        for j in range(n):
            if matrix[0][j] < min_sum:
                min_sum = matrix[0][j]

        return min_sum

# Driver code
solution = Solution()
matrix = get_input()
print(f"Input matrix: {matrix}")
print(f"Approach 1: Brute force: Output min sum: {solution.minFallingPathSum_brute_force(matrix)}")
print(f"Approach 2: Dynamic programming: Output min sum: {solution.minFallingPathSum(matrix)}")
