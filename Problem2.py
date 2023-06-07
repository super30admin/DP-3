class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        rows = len(A)
        cols = len(A[0])

        # Initialize the dp array with the values of the first row
        dp = A[0]

        # Iterate through the remaining rows
        for i in range(1, rows):
            # Create a new dp array for the current row
            new_dp = [0] * cols

            # Calculate the minimum falling path sum for each element in the current row
            for j in range(cols):
                # Find the minimum path sum by considering the elements from the previous row
                prev_row_min = min(dp[max(0, j - 1):min(cols, j + 2)])
                new_dp[j] = A[i][j] + prev_row_min

            # Update the dp array with the new row
            dp = new_dp

        # Return the minimum falling path sum from the last row
        return min(dp)