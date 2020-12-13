
# Approach: Dynamic programming
# The apporach to this problem would be the same as the paint house (https://leetcode.com/problems/paint-house/) problem. A slight modification is that the size of the row is not fixed and there is one addded condition. So we will approach the problem similarly where in matrix we will update each value to minimum sum to reach that point. That means minimum value in last row will contain the minimum sum.

# Time Complexity: O(m*n) where m = no of rows, n = no of columns
# Space Complexity: O(1)

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if A == None or len(A) == 0:
            return 0
        
        m = len(A)
        n = len(A[0])
        
        for i in range(1, m):
            for j in range(n):
                
                # Case 1: Left border
                if (j == 0):
                    A[i][j] += min(A[i-1][j], A[i-1][j+1])

                # Case 2: Right border
                elif (j == len(A[0]) - 1):
                    A[i][j] += min(A[i-1][j-1],A[i-1][j])   
                    
                # Case 3: Middle
                else:
                    A[i][j] += min(A[i-1][j-1], min(A[i-1][j], A[i-1][j+1]))
                    
        print(A)
            
        return min(A[-1]) 