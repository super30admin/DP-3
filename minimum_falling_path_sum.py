"""
Problem: Minimum Falling Path Sum
Leetcode: https://leetcode.com/problems/minimum-falling-path-sum/
Example:
    Input: [[1,2,3],[4,5,6],[7,8,9]]
    Output: 12
Solution: Dynamic programming
Time Complexity: O(m*n) we're traversing each element of matrix array
Space Complexity: O(m*n) as we're defining a new matrix array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
"""

class Solution:
    def min_falling_path_sum(self, A):
        # Base cases
        if A is None or len(A) is 0 or len(A[0]) is 0:
            return 0

        # Dimensions of a new array should match with an input array
        rows = len(A)
        cols = len(A[0])

        # Define a new matrix array
        dp = [[0 for x in range(rows)] for y in range(cols)]

        # Copy 1st row from input array to dp array
        for col in range(cols):
            dp[0][col] = A[0][col]

        # 2ns row onwards, put actual values into dp array
        for i in range(1, rows):
            for j in range(cols):
                # Case 1: 1st col (j, j+1)
                if j == 0:
                    dp[i][j] = A[i][j] + min(dp[i-1][j], dp[i-1][j+1])

                # Case 2: for last col (j-1, j)
                elif j == cols - 1:
                    dp[i][j] = A[i][j] + min(dp[i-1][j], dp[i-1][j-1])

                # Case 3: others (j-1,j,j+1)
                else:
                    dp[i][j] = A[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i-1][j+1])

        # As last row has final values, return min of last row
        return min(dp[rows-1])


obj = Solution()
print(obj.min_falling_path_sum([[1,2,3],[4,5,6],[7,8,9]]))