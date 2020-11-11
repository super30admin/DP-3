"""
Running on Leetcode
Time complexity - O(N)
The approach here is to iterate the 2-D array from backwards. Add the min value amoungst the available 
elements to add from the previous row. keep on doing this until you reach the first row. and finally the
minimum element sum in the first row indicates the correct minimum falling path.

"""

def minFallingPathSum(self, A):
        for i in reversed(range(len(A)-1)):
            for j in range(len(A[0])):
                if j == 0:
                    A[i][j] += min(A[i+1][j+1], A[i+1][j])
                elif j == len(A[0])-1:
                    A[i][j] += min(A[i+1][j-1],A[i+1][j])
                else:
                    A[i][j] += min(A[i+1][j-1],A[i+1][j],A[i+1][j+1])
                    
        return min(A[0])


