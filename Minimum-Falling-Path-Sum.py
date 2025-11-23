class Solution:
    '''
    First we take the n as len of the matrix, note that the question says the matrix is n x n so it is a square matrix.
    second we make the DP matrix same as the matrix provided
    third we substitute the 0th row of martix to DP.
    fourth we start by 2 for loops first from 1 to n and second inside from 0 to n. the first one is from 1 as we already added the 0th row in last step.
    fifth we check if the j is first column, mid column or the last column.
    sixth for first column we take the value from the matrix at the given i and j and add it the min of the i-1 and j value or i-1 and j+1 value. we do this for the other 2 cases as well with respected available j values
    seventh we take the minimum for the last row of dp as dp[-1] and that will be our answer.
    TC: 2n^2 + n
    SC: n^2
    Leetcode: was able to solve the problem with optimal approch, could not identify the recursive method to solve this problem
    Any problem you faced while coding this: while solving with SC as n. I was stuck on how to eleminate the use of previous row.
    '''
    def minFallingPathSum(self, matrix):
        n = len(matrix)
        dp = [[0 for each in range(n)] for every in range(n)]
        dp[0] = matrix[0]

        for i in range(1, n):
            for j in range(n):
                if j == 0:
                    dp[i][j] = matrix[i][j] + min( dp[i - 1][j], dp[i - 1][j + 1])
                elif j == n - 1:
                    dp[i][j] = matrix[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j])
                else:
                    dp[i][j] = matrix[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i - 1][j + 1])
        return min(dp[-1])


s = Solution()
matrix = [[2,1,3],[6,5,4],[7,8,9]]
print(s.minFallingPathSum(matrix))
matrix = [[-19,57],[-40,-5]]
print(s.minFallingPathSum(matrix))