# Time Complexity: O(log(N))
# Space Complexity: O(N)
# Passed Leetcode

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        if len(A) == 1:
            return min(A[0])
        
        m = [A[0]]
        
        for i in range(1, len(A)):
            
            row = []
            for j in range(len(A[0])):
                prev = []
                
                if j - 1 >= 0:
                    prev.append(m[i - 1][j - 1])
                if j + 1 < len(A[0]):
                    prev.append(m[i - 1][j + 1])
                
                prev.append(m[i - 1][j])
                
                row.append(A[i][j] + min(prev))
            m.append(row)
        
        return min(m[-1])
                