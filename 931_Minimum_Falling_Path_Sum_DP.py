class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:return 0
        ancestors = [[-1,-1], [-1,0], [-1, 1]]
        for i in range(1, len(A)):
            for j in range(len(A[i])):
                curr = float(inf)
                for ancestor in ancestors:
                    if i+ancestor[0] >= 0 and j+ancestor[1] >= 0 and j+ancestor[1] < len(A[i]):
                        curr = min(curr, A[i][j] + A[i+ancestor[0]][j+ancestor[1]])
                A[i][j] = curr
                
        res = float(inf)
        for i in range(len(A[0])):
            res = min(res, A[len(A)-1][i])
        return res