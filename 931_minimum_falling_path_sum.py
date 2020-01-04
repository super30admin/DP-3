from typing import List


class Solution:

    def minFallingPathSum(self, A: List[List[int]]) -> int:
        """
            https://leetcode.com/problems/minimum-falling-path-sum/
            // Time Complexity :
            // Space Complexity :
            // Did this code successfully run on Leetcode :
            // Any problem you faced while coding this :


            // Your code here along with comments explaining your approach

        """

        pass

    def minFallingPathSumBruteForce(self, A: List[List[int]]) -> int:
        """
           // Time Complexity :
           // Space Complexity :
           // Did this code successfully run on Leetcode :
           // Any problem you faced while coding this :


           // Your code here along with comments explaining your approach

        """
        rows = len(A)
        for j in range(len(A[0])):
            i = 0
            # sum = A[i][j]
            # print(sum)
            i += 1
            while i < rows:
                print(A[i][j], end=' ')
                if j != len(A[0]) - 1:
                    print(A[i][j + 1], end=' ')
                if j != 0:
                    print(A[i][j - 1], end=' ')
                print()
                i += 1
            # if j == len(A) - 1:


if __name__ == '__main__':
    sol = Solution()
    sol.minFallingPathSumBruteForce(
        [[1, 2, 3],
         [4, 5, 6],
         [7, 8, 9]]
    )
    # sol.minFallingPathSum([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
