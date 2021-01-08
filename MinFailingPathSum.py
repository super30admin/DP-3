# TC= O(m*n)
# SC= O(1)
# Recursion approach below. Similar to paint house question
# DP: we start with second last row- for each element we take the min of elements of consideration from next row up until we compute values for first row. min of first row is our result. 

# class Solution:
#     def minFallingPathSum(self, A):
#         def helper(A, num, row, col):
#             # base
#             if row >= len(A):
#                 return num           
#             # logic
#             right, left = None, None
#             if col - 1>= 0:
#                 left = helper(A,A[row][col-1]+ num, row+1, col-1)
#             center = helper(A, A[row][col] + num, row+1, col)
#             if col + 1 < len(A[0]):
#                 right = helper(A, A[row][col+1] + num, row+1, col+1)
#             # return
#             minFall = center
#             if left != None:
#                 minFall = min(minFall, left)
#             if right != None:
#                 minFall = min(minFall, right)
#             return minFall
#         ans = float('inf')
#         for j in range(len(A[0])):
#             i = 1
#             ans = min(ans, helper(A, A[0][j], i, j))
#         return ans

class Solution:
    def minFallingPathSum(self, A):
        while len(A) >= 2:
            row = A.pop()            
            for i in range(len(row)):
                A[-1][i] += min(row[max(0,i-1): min(len(row), i+2)])
        return min(A[0])

# Driver code
obj = Solution()
A = [[1,2,3],[4,5,6],[7,8,9]]
print(obj.minFallingPathSum(A))