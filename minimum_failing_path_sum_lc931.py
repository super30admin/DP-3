"""
Name: Srinidhi Bhat
Space Complexity: O(MN) - Extra DP 2D Array
Time Complexity: O(M x N) - Filling DP Array

Did it run on Leetcode: Yes
Logic:
1. Start from first row - The possiblity is to get min by adding the element with Col+1 (Since only one call can be considered)
for for last col element - The possiblity will be to get min by adding with second last column only

For inbetween columns, we have to checkthe columns surrounding that column.
"""
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        cache = [[A[i][j] for j in range(len(A[0]))]for i in range(len(A))]
        for i in range(1,len(A)):
            for j in range(len(A[0])):

                #edge cases are first column and last column which only have two paths from above
                if j == 0:
                    cache[i][j]  = min((A[i][j] + A[i - 1][j]), (A[i][j] + A[i - 1][j + 1]) )

                elif (j == len(A[0]) - 1):
                    cache[i][j]  = min((A[i][j] + A[i - 1][j]), (A[i][j] + A[i - 1][j - 1]) )

                #every other column will have three paths coming from above
                else:
                    cache[i][j] = min(A[i][j] + A[i - 1][j],A[i][j] + A[i - 1][j + 1], A[i][j] + A[i - 1][j - 1])
        print(cache)
        # Now that minimum falling sums for each value at the bottom row have been computer
        # We can just take the min of the bottow row to get the smallest overall path sum 
        return min(cache[len(A) - 1])