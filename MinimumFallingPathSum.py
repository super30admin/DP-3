# Time Complexity => O(N*N)
# Space Complexity => O(1)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if(len(matrix)==0):
            return 0
        n = len(matrix)
        for i in range(n-2,-1,-1):
            for j in range(n):
                if(j==0):
                    matrix[i][j]+= min(matrix[i+1][j], matrix[i+1][j+1])
                elif(j==n-1):
                    matrix[i][j]+= min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j]+= min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])
        min_element=sys.maxsize
        for i in range(n):
            min_element = min(min_element, matrix[0][i])
        return min_element
        