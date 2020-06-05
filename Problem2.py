from typing import List

"""
    Student : Shahreen Shahjahan Psyche
    Dynammic Programming:
        Time Complexity : O(N^2)
        Space Complexity : O(1)
    This solution successfully passed all the test cases in Leetcode
"""

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        # edge case
        if A is None or len(A) == 0:
            return 0    
        n = len(A)
        for i in range(1, n):
            for j in range(n):
                # Boundary case
                if j == 0:
                    A[i][j] = min(A[i][j] + A[i-1][j], A[i][j] + A[i-1][j+1])
                # Boundary case
                elif j == n-1:
                    A[i][j] = min(A[i][j] + A[i-1][j], A[i][j] + A[i-1][j-1])
                else:
                # Taking the minimum value from the previous row's one + current one's summed value. As we can chose atmost 3 indexes 
                # thats why taking the minimum summed value out of these 3 options
                    A[i][j] = min(A[i][j] + A[i-1][j-1] , A[i][j] + A[i-1][j], A[i][j] + A[i-1][j+1])
                    
        min_falling = min(A[n-1][:])
       
        return min_falling
                    