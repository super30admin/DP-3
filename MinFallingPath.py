class Solution:
    """
    Time complexity - O(n*n) n*n is size of matrix
    Space complexity - O(n) 
    """
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        if n == 1:
            return matrix[0][0]
        #stores the minimum path sum at i till the previous row.
        prev_itr = [0 for i in range(0,n)]
        #stores the minimum path sum at i at the previous row.
        curr_itr = [0 for i in range(0,n)]
        for x in range(0,n):
            y = 0
            curr_itr[0] = min(prev_itr[y], prev_itr[y+1]) + + matrix[x][y]
            for y in range(1,n-1):
                # minimum path sum can be from left column, same column , previous column of the prev_itr
                curr_itr[y] = min(prev_itr[y-1], prev_itr[y], prev_itr[y+1]) + matrix[x][y]
            y = n-1
            curr_itr[n-1] = min(prev_itr[y-1], prev_itr[y]) + + matrix[x][y]
            prev_itr = curr_itr.copy()
        result = sys.maxsize
        for x in range(0,n):
            result = min(result, curr_itr[x])
        return result
        