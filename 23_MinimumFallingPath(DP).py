# time - O(N^2), space - O(1)
# Accepted in leetcode
# For every digit we have to look for minimum falling path from above but can go max of one place ahead.
def minFallingPathSum(A):
    n = len(A)
    # dp = [[0 for i in range(len(A))] for j in range(len(A[0]))]
    # dp[0] = A[0]
    for i in range(1, n):
        for j in range(n):
            # handling differently for 1st and last column and they dont have upper left and right respectively.
            if j == 0:
                A[i][j] = A[i][j] + min(A[i - 1][j], A[i - 1][j + 1])
            elif j == n - 1:
                A[i][j] = A[i][j] + min(A[i - 1][j - 1], A[i - 1][j])
            else:
                A[i][j] = A[i][j] + min(A[i - 1][j - 1], A[i - 1][j], A[i - 1][j + 1])
    # returning minimum sum from last row
    return min(A[n - 1])

print(minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]]))
