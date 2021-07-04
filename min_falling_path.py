#Time Complexity :  O(n^2)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no


class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        
        if len(matrix)==0:
            return 0
        if len(matrix)==1:
            return matrix[0][0]
        
        for n in reversed(range(len(matrix)-1)):
            for index,num in enumerate(matrix[n]):
                if index==0:
                    matrix[n][index] += min(matrix[n+1][index],matrix[n+1][index+1])
                elif index == len(matrix)-1:
                    matrix[n][index] += min(matrix[n+1][index],matrix[n+1][index-1])
                else:
                    matrix[n][index] += min(matrix[n+1][index],min(matrix[n+1][index+1],matrix[n+1][index-1]))
        return min(matrix[0])