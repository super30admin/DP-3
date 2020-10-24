#Time Complexity : O(n^2) where n is the length of input array
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if len(A) == 0 or A == None:
            return 0
        #iterate through each row
        for i in range(1, len(A)):
            #iterate through each column to get minimum sum by selecting from previous row where column is max off by one than current column
            for j in range(len(A[0])):
                if j > 0 and j < len(A[0])-1:
                    A[i][j] = min(A[i-1][j-1], A[i-1][j+1], A[i-1][j]) + A[i][j]
                #if element is on first column
                elif j == 0:
                     A[i][j] = min(A[i-1][j+1], A[i-1][j]) + A[i][j]
                #if element is on last column
                else:
                    A[i][j] = min(A[i-1][j-1], A[i-1][j]) + A[i][j]
                    
        #return minimum sum in last row
        return min(A[len(A)-1])
