# Time complexity is O(NM) and space complexity is O(NM)
class Solution2:
    def minFallingObject(self, matrix):
        N = len(matrix)
        cache = {}
        def dfs(r, c):
            if r==N:
                return 0
            if c<0 or c==N:
                return float("inf")
            
            if (r,c) in cache:
                return cache[(r,c)]
            
            res = matrix[r][c]+min(dfs(r+1, c+1), dfs(r+1, c), dfs(r+1, c-1))
            
            cache[(r,c)] = res
            return res       
        
        res = float('inf')
        for c in range(N):
            res = min(res, dfs(0, c))
        return res
            