#T(N)= O(N^2)
# S(N) = O(N^2)

# Where N is number of rows or columns
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        res= [[7686879878979 for i in range(len(matrix))] for i in range(len(matrix[0]))]
        m=len(matrix)
        n=len(matrix[0])
        for i in range(n):
            res[m-1][i]=matrix[m-1][i]
        ar=[[1,-1],[1,0],[1,1]]
        
        for i in range(m-2,-1,-1):
            for j in range(n):
                for a in ar:
                    ti=i+a[0]
                    tj=j+a[1]
                    
                    if ti>=0 and ti<m and tj>=0 and tj<n:
                        
                        res[i][j]= min(res[i][j],matrix[i][j]+res[ti][tj])
        mi=math.inf
        for i in range(len(matrix)):
            mi=min(res[0][i],mi)
        return mi
            
            
                        
        