# Time Complexity : O(m * n) where m rows and n columns
# Space Complexity : O(1) - we use the same matrix to perform operations
# Did this code successfully run on LeetCode : yes
# Any problem you faced while coding this : No


# we will perform dp on the same matrix and keep track of our selection
# each time we select an item we will check add the existing value with min value of the previous row,
# along with the condition based on their position whether they are left edge or right edge or in center
# the minimum of our last row will be our minimum falling path sum, obtained from optimal previous states values

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:

        for i in range(1, len(A)):
            for j in range(len(A[0])):

                if j == 0:

                    A[i][j] += min(A[i - 1][j], A[i - 1][j + 1])

                elif j == len(A[0]) - 1:

                    A[i][j] += min(A[i - 1][j], A[i - 1][j - 1])

                else:

                    A[i][j] += min(A[i - 1][j + 1], A[i - 1][j], A[i - 1][j - 1])

        return min(A[-1][:])
