class MinFallingPathSum(object):
    '''
    Solution:
    1. A recursion problem where overlapping subproblems exist and so use Dynamic Programming.
    2. Update the given matrix by updating the current row's cell with sum of (minimum of previous row's
        3 columns (column - 1, column, column + 1).
    3. Return the minimum value obtained in the last row.

    --- Successfully passed all Leetcode testcases.
    '''
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """

        # O(numRows * numCols) Time Complexity | O(1) Space Complexity
        if (A == None or len(A) == 0):
            return 0

        for row in range(1, len(A)):
            for col in range(len(A[row])):
                actualValue = A[row][col]
                A[row][col] = actualValue + A[row - 1][col]
                if (col > 0):
                    A[row][col] = min(A[row][col], actualValue + A[row - 1][col - 1])
                if (col < len(A[row]) - 1):
                    A[row][col] = min(A[row][col], actualValue + A[row - 1][col + 1])

        minSum = A[len(A) - 1][0]
        for col in range(len(A[len(A) - 1])):
            if A[len(A) - 1][col] < minSum:
                minSum = A[len(A) - 1][col]

        return minSum
