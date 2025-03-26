# Problem 2 : Minimum Falling Path Sum
# Time Complexity : O(n^2) where n is the size of the matrix
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        # if the length of the matrix is 0 or the matrix is None
        if matrix is None or len(matrix) == 0:
            # return 0
            return 0
        # get the length of the matrix
        length = len(matrix)
        # loop from second last row to first row
        for i in range(length-2, -1, -1):
            # iterate through each column
            for j in range(0, length, 1):
                # if it is first column
                if j == 0:
                    # calculate the value at i and j position of matrix as sum of the value and minimum between value at (i+1)(j)th position and value at (i+1)(j+1)th position
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                # if it is last column
                elif j == length -1:
                    # calculate the value at i and j position of matrix as sum of the value and minimum between value at (i+1)(j)th position and value at (i+1)(j-1)th position
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j-1])
                # else if it is middle column in matrix
                else:
                    # calculate the value at i and j position of matrix as sum of the value and minimum between value at (i+1)(j)th position, value at (i+1)(j+1)th position and value at (i+1)(j-1)th postion
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], min(matrix[i+1][j-1], matrix[i+1][j+1]))
        # define minValue and set the it to first element in matrix
        minValue = matrix[0][0]
        # loop through first row in matrix
        for j in range(length):
            # store the minimum value between minValue and value at (0)(j)th position
            minValue = min(minValue, matrix[0][j]) 
        # return minValue
        return minValue
                    