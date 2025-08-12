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
https://youtu.be/4Qxb4VeFlCg?t=1526

Time: O(N^2), Space: O(1) (mutate the original array to store min falling path cost)
'''
import time
def min_falling_path_sum(A):
    ''' recursion without memoization '''
    def recurse(A, row, col):
        if row == N-1:
            return A[row][col]

        m = float('inf')
        if col==0:
            a = recurse(A, row+1, col)
            b = recurse(A, row+1, col+1)
            m = min(a, b)
        elif col == N-1:
            a = recurse(A, row+1, col-1)
            b = recurse(A, row+1, col)
            m = min(a, b)
        else:
            a = recurse(A, row+1, col-1)
            b = recurse(A, row+1, col)
            c = recurse(A, row+1, col+1)
            m = min(a, b, c)
        this = A[row][col]
        return this + m

    N = len(A)
    m = float('inf')
    if N == 0:
        return m
    assert N == len(A[0]), f"This is not a square matrix"


    for j in range(N):
        this = recurse(A, 0, j)
        m = min(m, this)
    return m


def min_falling_path_sum_dp(A):
    ''' dynamic programming (bottom-up) '''
    N = len(A)
    for i in range(N-2,-1,-1):
        for j in range(N):
            if j == 0:
                A[i][j] = A[i][j] + min(A[i+1][j], A[i+1][j+1])
            elif j == N-1:
                A[i][j] = A[i][j] + min(A[i+1][j-1], A[i+1][j])
            else:
                A[i][j] = A[i][j] + min(A[i+1][j-1], A[i+1][j], A[i+1][j+1])
    return min(A[0])


def run_min_falling_path_sum():
    tests = [([[2,1,3], [6,5,4], [7,8,9]],13), ([[-19, 57], [-40,-5]],-59), ([[1,2,3],[4,5,6],[7,8,9]], 12), ([[2]], 2), ([[1,2,10,4],[100,3,2,1],[1,1,20,2],[1,2,2,1]],6)]

    for test in tests:
        A, ans = test[0], test[1]
        start = time.time()*1000
        min_cost = min_falling_path_sum(A)
        elapsed =  time.time()*1000 - start
        print(f"\nmatrix = {A}")
        print(f"Min falling path sum = {min_cost}, time = {elapsed:.2f} ms (recursion)")
        print(f"Pass: {ans == min_cost}")

    for test in tests:
        A, ans = test[0], test[1]
        print(f"\nmatrix = {A}")
        start = time.time()*1000
        min_cost = min_falling_path_sum_dp(A)
        elapsed =  time.time()*1000 - start
        print(f"Min falling path sum = {min_cost}, time = {elapsed:.2f} ms (dp tabulation)")
        print(f"Pass: {ans == min_cost}")

run_min_falling_path_sum()