'''
931 Minimum Falling Path Sum

https://leetcode.com/problems/minimum-falling-path-sum/description/

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix. A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100

Example 1:
Input: [[2,1,3], [6,5,4], [7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as 1+5+7=13 or 1+4+8 = 13

Example 2:
Input: [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum as -19 + -40 = -59

Solution:
1. Brute Force (Recursion): Generate all possible paths and find the minimum cost among all those paths.
Time: O(3^N), Space: O(N)

2. Recursion with memoization (top-down approach): Same as recursion but using hash map to avoid repeated computation of sub problems.
Time: O(N), Space: O(N)

3. Tabulation (bottom-up approach):
Construct a 2-D DP array of size N x N to store the minimum cost of paths. Thus, dp[i][j] = min cost of falling path at ith row and jth col = cost + min (min cost of falling path at array[i+1][j-1], min cost of falling path at array[i+1][j], min cost of falling path at array[i+1][j+1])

This means:
dp[i][j] = array[i] [j] + {min(dp[i+1][k])},
where i = 0,...,N-2
where k = 0,1 if j = 0 (first col)
          N-2,N-1 if j = N-1 (last col)
          j-1,j,j+1, otherwise

Thus, for i = N-1, (last row)
dp[N-1][j] = array[N-1] [j] (since there are no remaining houses after the last house)

Hence, initialize the dp array by copying the last row of original array to the dp array and fill the remaining rows of dp array, i.e. rows N-2, N-3, ..., 0, using the dp formula.

Finally return the min of the first row dp[0][]
Time: O(N^2), Space: O(N^2) (if we use a new DP matrix to store min costs)
https://youtu.be/4Qxb4VeFlCg?t=1526


4. Tabulation (bottom-up approach, w/ input mutation):
Instead of creating a new DP matrix, we can reuse the input matrix
to store the dp values

Time: O(N^2), Space: O(1)
'''

def min_falling_path_sum(matrix):
    ''' recursion without memoization '''
    def recurse(mat, row, col):
        if row >= N or col >= N:
            return 0

        sum = 0
        this = mat[row][col]
        below = recurse(mat, row+1, col)
        if col == 0:
            right = recurse(mat, row+1, col+1)
            sum = min(this + below, this + right)
        elif col == N-1:
            left = recurse(mat, row+1, col-1)
            sum = min(this + below, this + left)
        else:
            left = recurse(mat, row+1, col-1)
            right = recurse(mat, row+1, col+1)
            sum = min(this + below, this + left, this +right)

        return sum

    N = len(matrix)
    assert N == len(matrix[0]), f"Matrix is not a square matrix"

    mn = float('inf')
    for j in range(N):
        this = recurse(matrix, 0, j)
        mn = min(mn, this)
    return mn

def min_falling_path_sum_dp1(matrix):
    ''' dynamic programming (bottom-up), w/o mutating the input matrix '''
    N = len(matrix)
    assert N == len(matrix[0]), f"Matrix is not a square matrix"

    if N == 0:
        return 0

    # init dp matrix with 0's
    dp = [[0]*N for _ in range(N)]

    # copy the last row of costs matrix (RGB cost of last house) to the dp matrix
    for j in range(N):
        dp[N-1][j] = matrix[N-1][j]

    for i in range(N-2,-1,-1):
        for j in range(N):
            if j == 0:
                dp[i][j] = matrix[i][j] + min(dp[i+1][0], dp[i+1][1])
            elif j == N-1:
                dp[i][j] = matrix[i][j] + min(dp[i+1][N-1], dp[i+1][N-2])
            else:
                dp[i][j] = matrix[i][j] + min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1])

    return min(dp[0])

def min_falling_path_sum_dp2(matrix):
    ''' dynamic programming (bottom-up), w/ mutating the input matrix '''
    N = len(matrix)
    assert N == len(matrix[0]), f"Matrix is not a square matrix"

    if N == 0:
        return 0

    for i in range(N-2,-1,-1):
        for j in range(N):
            if j == 0:
                matrix[i][j] = matrix[i][j] + min(matrix[i+1][0], matrix[i+1][1])
            elif j == N-1:
                matrix[i][j] = matrix[i][j] + min(matrix[i+1][N-1], matrix[i+1][N-2])
            else:
                matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])

    return min(matrix[0])


def run_tests():
    tests = [([[2,1], [6,5]],6),
             ([[2,1,3], [6,5,4], [7,8,9]],13),
             ([[-19, 57], [-40,-5]],-59),
             ([[1,2,3],[4,5,6],[7,8,9]], 12),
             ([[2]], 2),
             ([[1,2,10,4],[100,3,2,1],[1,1,20,2],[1,2,2,1]],6),
    ]

    for test in tests:
        matrix, ans = test[0], test[1]
        res1 = min_falling_path_sum(matrix)
        res2 = min_falling_path_sum_dp1(matrix)
        res3 = min_falling_path_sum_dp2(matrix)
        print(f"\nmatrix = {matrix}")
        print(f"Max sum = {res1} (recursion)")
        print(f"Max sum = {res2} (dp bottom up, w/o input mutation)")
        print(f"Max sum = {res3} (dp bottom up, w/ input mutation)")
        passed = (ans == res1 == res2 == res3)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")

    print(f"\nDONE")

run_tests()
