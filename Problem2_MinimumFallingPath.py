#Time Complexity: O(n*m)
#Space Complexity: O(1)
#LeetCode: Yes

'''
Approach: Used bottom-up approach to find minimum from next row and neighbouring cols, 
similar to paint house problem.
'''

class Solution:
    def minFallingPath(self, matrix):
        if len(matrix) == 0:
            return 0

        for i in range(len(matrix)-2, -1,-1):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                if j == len(matrix[0])-1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])

        return min(matrix[0])

obj = Solution()
matrix = [[2,1,3],[6,5,4],[7,8,9]]
print(obj.minFallingPath(matrix))