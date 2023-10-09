# // Time Complexity : O(n^2)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : Faced difficulty in formulating the logic


# I kept the first row of matrix as it is. Now kept updating the matrix elements buy adding the min element min(above, left diagnoally, right diagonllay)
# at the end, min element of last row ill give me the min falling sum
# we can do this from last row and go up. but i felt this easier to code
import math
matrix=[[2,1,3], [6,5,4], [7, 8, 9]]

n = len(matrix)

for i in range(1, n):
    for j in range(n):
        mini = math.inf
        for k in range(max(0, j - 1), min(n, j + 2)):
            mini = min(mini, matrix[i - 1][k])
        matrix[i][j] += mini

print(min(matrix[-1]))
