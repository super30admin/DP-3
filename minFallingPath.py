# Time Complexity : O(N^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach

class Solution(object):
    def minFallingPath(self, matrix):
        #Base case
        if not matrix or len(matrix) == 0:
            return 0
        
        n = len(matrix)
        #Using bottom-up DP approach
        for i in range(n - 2, -1, -1):
            for j in range(len(matrix)):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j + 1])
                elif j == n - 1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i + 1][j], matrix[i + 1][j - 1])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i][j - 1], matrix[i + 1][j], matrix[i + 1][j + 1])
        
        return min(matrix[0])

if __name__ == "__main__":
    fp = Solution()
    matrix = [[-19,57],[-40,-5]]
    ans = fp.minFallingPath(matrix)
    print(ans)