'''
TC: O(n)
SC: O(n)

Intuition: at any given point, consider rows till that point and calculate the min using the previous row values
'''
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        matlen = len(matrix)
        if not matlen:
            return []
        
        dp = [matrix[0][x] for x in range(matlen)]
        
        for idx in range(1, matlen):
            newdp = [0 for x in range(matlen)]
            for jdx in range(matlen):
                newdp[jdx] = min(dp[jdx-1] if jdx - 1 >= 0 else float("INF"), dp[jdx], dp[jdx+1] if jdx + 1 < matlen else float("INF")) + matrix[idx][jdx]
            dp = newdp
        
        return min(dp)
                

        ''' exhaustive
        def rec(x, y, matrix, matlen):
            # base
            if x >= matlen or y < 0 or y >= matlen:
                return float("INF")
            
            if x == matlen - 1:
                return matrix[x][y]
            
            #logic
            case1 = rec(x+1, y, matrix, matlen)
            case2 = rec(x+1, y+1, matrix, matlen)
            case3 = rec(x+1, y-1, matrix, matlen)
            
            return matrix[x][y] + min(case1, case2, case3)
        
        minm = float("INF")
        for col in range(matlen):
            minm = min(minm, rec(0, col, matrix, matlen))
        
        return minm
        '''
        