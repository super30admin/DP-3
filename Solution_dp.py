"""
Time Complexity O(N^2)
Space Conplexity O(1)

"""
class Solution_dp:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if A is None or len(A)==0:
            return 0
        for r in range(1, len(A)):
            for c in range(len(A[0])):
                if c-1<0:
                    A[r][c] += min(A[r - 1][c], A[r - 1][c + 1])
                elif c == len(A[0]) - 1:
                    A[r][c] += min(A[r - 1][c], A[r - 1][c - 1])
                else:
                    A[r][c] += min(A[r - 1][c], A[r - 1][c - 1], A[r - 1][c + 1])
        return min(A[len(A) -1])