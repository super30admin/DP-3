#Tc = O(n^2)
#sc = O(n^2)
#ran on leetcode: yes



def minFallingPathSum(self, matrix: List[List[int]]) -> int:
    
    rows, cols = len(matrix), len(matrix[0])
    mins = 10**20
    
    d = {}
    
    def dfs(row, col):
        
        if row==(rows-1): return matrix[row][col]
        
        if (row, col) in d: return d[(row, col)]
        
        if col in range(1, cols-1):
            d[(row,col)] = matrix[row][col] + min(dfs(row+1, col-1), dfs(row+1, col), dfs(row+1, col+1))
            return d[(row,col)]
        elif col==0:
            d[(row,col)] = matrix[row][col] + min(dfs(row+1, col), dfs(row+1, col+1))
            return d[(row,col)]
        elif col==cols-1:
            d[(row,col)] = matrix[row][col] + min(dfs(row+1, col-1), dfs(row+1, col))
            return d[(row,col)]
        
    for i in range(cols):
        mins = min(mins, dfs(0,i))
    
    return mins