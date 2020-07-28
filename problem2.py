# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        prev = A[0]
        
        for i in range(1, len(A)):
            temp = [0 for _ in range(len(A[0]))]
            for j in range(len(A[0])):
                if j == 0:
                    temp[j] = min(prev[j], prev[j+1]) + A[i][j]
                elif j == len(A[0])-1:
                    temp[j] = min(prev[j], prev[j-1]) + A[i][j]
                else:
                    temp[j] = min(prev[j], prev[j-1], prev[j+1]) + A[i][j]
                    
            prev = temp
            
        return min(prev)