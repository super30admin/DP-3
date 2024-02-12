"""
    TC: O(m x n)
    OC: O(m)

    Explaination: 
    - Similar to Paint house problem 
    - DP solution
    - add min from the bottom 3 and add to the current element 
    - In the end loop over the final row and find min
"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        least_sum = matrix[len(matrix)-1].copy()
        res = float('inf')
        print (least_sum)
        for i in range(len(matrix)-2, -1, -1):
            temp_sum = list()
            for j in range(0, len(matrix[0])):
                if j == 0:
                    left = float('inf')
                else:
                    left = least_sum[j-1]
                below = least_sum[j]
                if j == len(least_sum) - 1:
                    right = float('inf')
                else:
                    right = least_sum[j+1]
                a = matrix[i][j] + min(left, min(below, right))
                temp_sum.append(a)
            least_sum = temp_sum

        for i in range(0, len(least_sum)):
            res = min(res, least_sum[i])
        return res