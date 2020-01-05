from typing import List
from math import inf


class Solution:

    def minFallingPathSum(self, A: List[List[int]]) -> int:
        """
            https://leetcode.com/problems/minimum-falling-path-sum/
            // Time Complexity : O(mn)
                            'm' the number of rows, 'n' is the number of cols
            // Space Complexity : O(1)
                            We are manipulating the existing array
            // Did this code successfully run on Leetcode :
                            Yes
            // Any problem you faced while coding this :
                            Updated as per discussion in class
            // Your code here along with comments explaining your approach
                            For each element we are two options if we are at
                            the first and last column and three options if we
                            are in between.
        """
        # edge case
        if not A:
            return 0

        rows = len(A)
        cols = len(A[0])

        # ignoring 1st row because the
        # minimum at each cell is the best we can have
        for row in range(1, rows):
            for col in range(cols):
                # if we are at the first column
                if col == 0:
                    A[row][col] += min(A[row - 1][col], A[row - 1][col + 1])
                # if we are at the last column
                elif col == cols - 1:
                    A[row][col] += min(A[row - 1][col], A[row - 1][col - 1])
                # if we are some where in the middle
                else:
                    A[row][col] += min(A[row - 1][col], A[row - 1][col - 1], A[row - 1][col + 1])
        # returnig minimum from the last row
        return min([A[rows - 1][col] for col in range(cols)])

    def minFallingPathSumBruteForce(self, A: List[List[int]]) -> int:
        """
           // Time Complexity : O(n*3^m)
                        'n' is the number of columns
                        'm' is the number of rows
           // Space Complexity : O(m) if stack space is considered
                                 else costant
           // Did this code successfully run on Leetcode :
                                 TLE
        """
        # edge case
        if not A:
            return 0

        # making trees for each of the column in the first row
        return min([self._helper(A, 0, 0, col) for col in range(len(A[0]))])

    def _helper(self, A: List[List[int]], sum: int, row: int, col: int):

        # base case
        if row == len(A):
            return sum

        # logic
        case_1 = case_2 = case_3 = inf
        # case 1
        # we are at the first column
        if col == 0:
            case_1 = self._helper(A, sum + A[row][col], row + 1, col)
            case_2 = self._helper(A, sum + A[row][col], row + 1, col + 1)
        # case 2
        # we are at the last column
        elif col == len(A[0]) - 1:
            case_1 = self._helper(A, sum + A[row][col], row + 1, col)
            case_2 = self._helper(A, sum + A[row][col], row + 1, col - 1)
        # case 3
        # we are some where in between
        else:
            case_1 = self._helper(A, sum + A[row][col], row + 1, col)
            case_2 = self._helper(A, sum + A[row][col], row + 1, col + 1)
            case_3 = self._helper(A, sum + A[row][col], row + 1, col - 1)

        return min(case_1, case_2, case_3)


if __name__ == '__main__':
    sol = Solution()
    print(sol.minFallingPathSumBruteForce(
        [[1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]]
    ))
    print(sol.minFallingPathSum(
        [[1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]]
    ))
    print(sol.minFallingPathSum(
        [[5, 7, 4],
         [1, 3, 6],
         [1, 3, 5]]))
    print(sol.minFallingPathSumBruteForce(
        [[5, 7, 4],
         [1, 3, 6],
         [1, 3, 5]]))
    print(sol.minFallingPathSum(
        [[-80, -13, 22],
         [83, 94, -5],
         [73, -48, 61]]))
    print(sol.minFallingPathSumBruteForce(
        [[-80, -13, 22],
         [83, 94, -5],
         [73, -48, 61]]))
