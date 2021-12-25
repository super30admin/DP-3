# Time:O(n^2)
# Space: O(1)
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        for i in range(1, len(matrix)):
            for j in range(len(matrix)):
                mx = 1000
                if j == 0:
                    mx = min(matrix[i-1][j], matrix[i-1][j+1])
                elif j == len(matrix)-1:
                    mx = min(matrix[i-1][j], matrix[i-1][j-1])
                else:
                    mx = min(matrix[i-1][j+1], min(matrix[i-1][j], matrix[i-1][j-1]))
                matrix[i][j] += mx
        ans = 10000
        n = len(matrix) - 1
        for i in range(len(matrix)):
            ans = min(ans, matrix[n][i])
        #print(matrix)
        return ans
            
                
                    
                    
        
