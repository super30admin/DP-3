#problem: Minimum Falling Path Sum
#time complexity: O(m*n)
#space complexity: O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Dynamic programming
# 1. Construct a dp array with the same dimensions as the input matrix
# 2. Iterate through the matrix and calculate the minimum sum by taking the previous sum and the current sum
# 3. Return the minimum sum


class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        dp_arr = matrix[0][:]

        for i in range(1, len(matrix)):
            temp = dp_arr[:]
            for j in range(len(matrix[0])):
                if j == 0:
                    dp_arr[j] = min(temp[j], temp[j + 1]) + matrix[i][j]
                elif j == len(matrix[0]) - 1:
                    dp_arr[j] = min(temp[j], temp[j - 1]) + matrix[i][j]
                else:
                    dp_arr[j] = min(temp[j], temp[j + 1], temp[j - 1]) + matrix[i][j]

        return min(dp_arr)

    def FindMinPath2(self, arr):
        nrows = len(arr)
        ncols = len(arr[0])
        dp_arr = [[None for i in range(ncols)] for j in range(nrows)]
        dp_arr[0] = arr[0][:]

        for i in range(1, nrows):
            for j in range(ncols):
                if j == 0:
                    dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j + 1]) + arr[i][j]
                elif j == len(arr[0]) - 1:
                    dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j - 1]) + arr[i][j]
                else:
                    dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j + 1], dp_arr[i - 1][j - 1]) + arr[i][j]

        return min(dp_arr[-1])
