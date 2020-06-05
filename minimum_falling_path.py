# Time Complexity : Add - O(mn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes.

# Any problem you faced while coding this : No

'''
1. I have used a Table Approach as described in the lecture
2. Any particular element A[i][j] can be part of falling sum, either through the element just above it OR

or the element in the previous row at A[row-1][col '+ or -' 1] 

3. Leveraging that idea I use a top down approach while also calculating the cumulative min sum at each element so that it can be re-used.
'''

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        if A == [] or len(A) < 1:
            return 0
        rows = len(A)
        cols = len(A[0])
        

        for j in range(1,rows):
            for i in range(cols):
                if i == 0:
                    A[j][i] += min(A[j-1][i], A[j-1][i+1])
                    
                elif i == cols-1:
                    
                    A[j][i] += min(A[j-1][i], A[j-1][i-1])
                else:
                    # print(A)
                    A[j][i] += min(A[j-1][i], A[j-1][i-1], A[j-1][i+1])
                
        # print ("A",A)
                
        return min(A[rows-1])
                
                