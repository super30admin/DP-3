#
# Time complexity = O(n^2) where n is size of input
# Space complexity = O(n^2) where n is size of input
# Works on leetcode
#
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        st = [[0 for i in range(len(A))] for j in range(len(A))]
        n = len(A)
        for i in range(n-1, -1, -1):
            for j in range(0, n):
                if i == n-1:
                    st[i][j] = A[i][j]
                else:
                    neighbors = [float("inf"), float("inf"), float("inf")]
                    if j-1 >= 0:
                        neighbors[0] = A[i][j]+st[i+1][j-1]
                    if j+1 < n:
                        neighbors[2] = A[i][j]+st[i+1][j+1]
                    neighbors[1] = A[i][j]+st[i+1][j]
                    st[i][j] = min(neighbors)
        return (min(st[0]))
