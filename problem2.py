#   Time Complexity : O(RxC) Where R is no of Rows and C is no of Columns
#  Space Complexity : O(1) Any extra space is not used.
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : This question looks similer to the house paint problem. It is similer if instead of three color we have variable number of color.

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        for row in range(len(A) - 2, -1, -1):
            for col in range(len(A[row])):
                if col == 0:
                    A[row][col] += min(A[row+1][col], A[row+1][col+1])
                elif col == len(A[row]) - 1:
                    A[row][col] += min(A[row+1][col], A[row+1][col-1])
                else:
                    A[row][col] += min(A[row+1][col], A[row+1][col-1], A[row+1][col+1])
        return min(A[0])
        