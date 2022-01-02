# Time Complexity: O(n^2)
# Space Complexity: O(n^2) but can be done in O(1)
import sys
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
#DP Constant Space
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix)):
                if j == 0:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == len(matrix)-1:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j])
                else:
                    matrix[i][j] = matrix[i][j] + min(matrix[i+1][j-1], matrix[i+1][j], matrix[i+1][j+1])
        return min(matrix[0])
# DP
        # dp = [[sys.maxint for i in range(len(matrix))] for i in range(len(matrix))]
        # x = len(matrix)-1
        # for j in range(len(matrix)):
        #     dp[x][j] = matrix[x][j]
        # # print(dp)
        # for i in range(len(matrix)-2, -1, -1):
        #     for j in range(len(matrix)):
        #         if j == 0:
        #             dp[i][j] = matrix[i][j] + min(dp[i+1][j], dp[i+1][j+1])
        #         elif j == len(matrix)-1:
        #             dp[i][j] = matrix[i][j] + min(dp[i+1][j-1], dp[i+1][j])
        #         else:
        #             dp[i][j] = matrix[i][j] + min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1])
        #     # print(dp)
        # return min(dp[0])

# Exhaustive Approach
        # def helper(matrix, i, row, cost, hashmap):
        #     #Base
        #     if row == len(matrix)-1: return cost
        #     #Memo
        #     if hashmap.has_key((i,row,cost)):
        #         return hashmap[(i,row,cost)]
        #     #Logic
        #     if i == 0:
        #         x = helper(matrix, i, row+1, cost+matrix[row+1][i], hashmap)
        #         y = helper(matrix, i+1, row+1, cost+matrix[row+1][i+1], hashmap)
        #         hashmap[(i, row+1, cost+matrix[row+1][i])] = x
        #         hashmap[(i+1, row+1, cost+matrix[row+1][i+1])] = y
        #         return min(x, y)
        #     elif i == len(matrix[0])-1:
        #         x = helper(matrix, i-1, row+1, cost+matrix[row+1][i-1], hashmap)
        #         y = helper(matrix, i, row+1, cost+matrix[row+1][i], hashmap)
        #         hashmap[(i-1, row+1, cost+matrix[row+1][i-1])] = x
        #         hashmap[(i, row+1, cost+matrix[row+1][i])] = y
        #         return min(x, y)
        #     else:
        #         x = helper(matrix, i-1, row+1, cost+matrix[row+1][i-1], hashmap)
        #         y = helper(matrix, i, row+1, cost+matrix[row+1][i], hashmap)
        #         z = helper(matrix, i+1, row+1, cost+matrix[row+1][i+1], hashmap)
        #         hashmap[(i-1, row+1, cost+matrix[row+1][i-1])] = x
        #         hashmap[(i, row+1, cost+matrix[row+1][i])] = y
        #         hashmap[(i+1, row+1, cost+matrix[row+1][i+1])] = y
                
        #         return min(x, y, z)
            
            

        # min_val = sys.maxint
        # for i in range(len(matrix[0])):
        #     min_val = min(min_val, helper(matrix, i, 0, matrix[0][i], {}))
        # return min_val