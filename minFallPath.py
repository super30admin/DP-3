# Leetcode 931. Minimum Falling Path Sum

# Time Complexity :  O(n^2) where n is the size of the array

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: use the sum of current cell value and the min of previous row values of the eligible colums
# Return the max value from last column 

# Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        for i in range(1,len(A)):
            for j in range(0,len(A)):
                if j == 0:
                    A[i][j] += min(A[i-1][j+1], A[i-1][j])
                    
                elif j==len(A)-1:
                    A[i][j] += min(A[i-1][j-1], A[i-1][j])
                    
                else:
                    A[i][j] += min(A[i-1][j+1], A[i-1][j],A[i-1][j-1])
        
        return min(A[len(A)-1])