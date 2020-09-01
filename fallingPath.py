"""
# Given a square array of integers A, we want the minimum sum of a falling path through A.

Time = O(nm); n = number of rows, m = number of coloumns
space = constant; in-space modification
Successfully excecuted on leetcode

Approach - 
Dynamic programming
At each step, remove number of values using the constraint given(The next row's choice must be in a column that is different from the previous row's column by at most one.). Take the minimum of remaining values.

"""

class FallingPath:
    def minFallingPathSum(self, A: List[List[int]]) -> int:

        for i in range(1,len(A)): # row
            for j in range(len(A[0])): # coloumn

                #edge case : first column will have only have two paths possible
                if j == 0:
                    A[i][j]  += min(A[i - 1][j], A[i - 1][j + 1]) 
                    
                #edge case : last coloumn, have only two paths possible
                elif (j == len(A[0]) - 1):
                    A[i][j]  += min(A[i - 1][j], A[i - 1][j - 1]) 

                #Rest all other column will have three paths coming from above
                else:
                    A[i][j] += min(A[i - 1][j],A[i - 1][j + 1], A[i][j] + A[i - 1][j - 1])

        # Take the min of the bottow row to get the smallest overall path sum 
        return min(A[len(A) - 1])
  