"""
time: O(n^2)
space:O(n)
Leet: accepted
Problems faced: Struggled with converting logic into code
"""

class Solution(object):
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        #each element of temp keeps track of mincost if element at A[row][col] is included
        #we initialize with first row since that will be mincost if elements of A[0] have to be included
        temp = A[0]
        for row in range(1,len(A)):
            #we compute each element of new_temp by adding minimum of previous temp among allowed paths
            #to element at A[row][column]
            new_temp = []
            for col in range(len(temp)):
                new_temp.append(A[row][col] + min(temp[max(0,col-1):min(len(temp),col+2)]))
            #we update temp with new temp
            temp = new_temp

        return min(temp)
