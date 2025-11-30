class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        """
        Problem Summary:
        Given an n x n matrix, find the minimum sum of a falling path.
        A falling path starts from any cell in the first row and moves to the next row
        straight down, down-left, or down-right. Return the minimum possible path sum.

        Optimal Approach:
        Use dynamic programming where arr[col] stores the minimum path sum reaching
        the current row. For each new row, compute new values based on the three allowed
        transitions from the previous row.

        Time Complexity:  O(n^2)
            We process every cell once and compute its transition in O(1).
        Space Complexity: O(n)
            Only one row (arr) is kept at a time.

        One-liner summaries of all approaches:
        1. Recursive + Memo: DFS from each top cell, memoize min sum downwards.
        2. Bottom-Up DP (2D): dp[i][j] = matrix[i][j] + min(dp[i-1][j], dp[i-1][j±1]).
        3. Optimized DP (1D): Keep only previous row (rolling array), update row by row.
        4. In-place DP: Update matrix in-place to save space (no extra arrays).
        5. Final Optimal: Use a 1D rolling DP array for O(n) memory and O(n²) time.
        """

        rows = len(matrix)
        if rows == 0:
            return 0

        # arr[c] represents the min path sum to reach column c in the current row
        arr = matrix[0][:]  
        cols = len(arr)

        for r in range(1, rows):
            prevRow = arr[:]  # Snapshot of previous row DP values
            for c in range(cols):
                top     = prevRow[c]
                topLeft = prevRow[c - 1] if c > 0 else float('inf')
                topRight= prevRow[c + 1] if c < cols - 1 else float('inf')

                arr[c] = matrix[r][c] + min(top, topLeft, topRight)

        return min(arr)
