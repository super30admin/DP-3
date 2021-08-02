#minimum falling path sum
#time complexity:O(n*n) where n is the matrix  row and columns
#leetcode solution accepted

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        for i in range(1,len(A)):
            for j in range(len(A[0])):
		
            #edge cases are first column and last column which only have two paths from above
                if j == 0:
                    A[i][j]  = min((A[i][j] + A[i - 1][j]), (A[i][j] + A[i - 1][j + 1]) )

                elif (j == len(A[0]) - 1):
                    A[i][j]  = min((A[i][j] + A[i - 1][j]), (A[i][j] + A[i - 1][j - 1]) )

                #every other column will have three paths coming from above
                else:
                    A[i][j] = min(A[i][j] + A[i - 1][j],A[i][j] + A[i - 1][j + 1], A[i][j] + A[i - 1][j - 1])

        # Now that minimum falling sums for each value at the bottom row have been computed
        # We can just take the min of the bottow row to get the smallest overall path sum 
        return min(A[len(A) - 1])
        