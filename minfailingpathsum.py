class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)

        prev = matrix[0][:]

        for i in range(1, n):
            curr = [0] * n

            for j in range(n):
                up = prev[j]
                left = prev[j-1] if j > 0 else float('inf')
                right = prev[j+1] if j < n-1 else float('inf')

                curr[j] = matrix[i][j] + min(up, left, right)

            prev = curr

        return min(prev)

    # TC - O(n^2)
    # SC - O(n)