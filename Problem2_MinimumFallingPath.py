'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 931. Minimum Falling Path Sum
# Given an n x n array of integers matrix, return the minimum sum of any falling 
# path through matrix.

# A falling path starts at any element in the first row and chooses the 
# element in the next row that is either directly below or diagonally 
# left/right. Specifically, the next element from position (row, col) will 
# be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

# Example 1:
# Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
# Output: 13
# Explanation: There are two falling paths with a minimum sum underlined below:
# [[2,1,3],      [[2,1,3],
#  [6,5,4],       [6,5,4],
#  [7,8,9]]       [7,8,9]]

# Example 2:
# Input: matrix = [[-19,57],[-40,-5]]
# Output: -59
# Explanation: The falling path with a minimum sum is underlined below:
# [[-19,57],
#  [-40,-5]]

# Example 3:
# Input: matrix = [[-48]]
# Output: -48

#-----------------
# Time Complexity: 
#-----------------
# O(N^2): Given an N X N matrix, we need to traverse all the elements once.
#------------------
# Space Complexity: 
#------------------
# O(N): Storing only an array of size N

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes
# Time             :   116 ms ( 71.59 %ile)
# Space            :   15.2 MB ( 33.05 %ile)


from typing import List

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0:
            return 0
        
        elif len(matrix) == 1:
            return matrix[0][0]

        else:
            n = len(matrix)

            #We need a dp array to store minimum possible falling path 
            #sum starting from any of the elements in the first row
            dp = matrix[0]
            
            #Top-down DP
            for row in range(0,n-1):
                # Temporary copy of previous dp array
                prev_dp = list(dp)
                for column in range(n):
                    # Operation to handle column = 0
                    # If we are at the beginning at the list, no more
                    # previous elements
                    prev_col = max(column-1, 0)
                                        
                    # Operation to handle column = n-1
                    # If we reach end of list, no more elements to
                    # look up
                    next_col = min(n-1, column+1)                    
                    
                    dp[column] = matrix[row+1][column] + \
                                        min(prev_dp[prev_col], \
                                            prev_dp[column], \
                                            prev_dp[next_col])
            
            return min(dp)

obj = Solution()
# print(obj.minFallingPathSum(\
#     [[100,-42,-46,-41],\
#     [31,97,10,-10],\
#     [-58,-51,82,89],\
#     [51,81,69,-51]])\
# )

# print(obj.minFallingPathSum(\
#    [[-19,57],\
#    [-40,-5]]
# ))
