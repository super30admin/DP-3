# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
def minFallingPathSum(A):
        
        if len(A) == 0:
            return 0

        for i in range(1, len(A)): 
            for j in range (0, len(A)):     
                # if the nums are on either of the edges
                if j == 0:
                    A[i][j] += min(A[i-1][j+1],A[i-1][j])
                elif j == (len(A)-1):
                    A[i][j] += min(A[i-1][j-1], A[i-1][j])
                # if the nums are in the middle take minimum of the top, left and right values
                else:
                    A[i][j] += min(A[i-1][j-1], min(A[i-1][j], A[i-1][j+1]))

        return print(min(A[len(A)-1]))

minFallingPathSum([[1,2,3],[4,5,6],[7,8,9]])