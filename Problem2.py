#Minimum Falling Path Sum

#Time complexity O(mxn)
#Space complexity O(m) where m is the number of columns in the matrix
#The idea is to calculate for each index starting from row 2 what's the minimum sum we can achieve in that index. to minimise the sum at each index the logic will be
# sum of price at that index and the minimimum of the three/two from the top row. Dependinging if it's a middle index or at the edges of the matrix
#This will give the minimum sum at each index that is possible. In the end we'll just find in all the index which has the minimimu sum and return that
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        columns = len(matrix[0])
        rows = len(matrix)
        psblValuesAtEachColumn = [0]*columns
        for j in range(0,columns):
            psblValuesAtEachColumn[j] = matrix[0][j]

        for i in range (1, rows):
            previousTopVal = None
            for j in range(0,columns):
                currentTopVal = psblValuesAtEachColumn[j]
                if previousTopVal == None:
                    psblValuesAtEachColumn[j] = matrix[i][j] + min(psblValuesAtEachColumn[j],psblValuesAtEachColumn[j+1])
                    previousTopVal = currentTopVal
                elif j==columns-1:
                    psblValuesAtEachColumn[j] = matrix[i][j] + min(previousTopVal, psblValuesAtEachColumn[j])
                else:
                    psblValuesAtEachColumn[j] = matrix[i][j] + min(previousTopVal, psblValuesAtEachColumn[j],psblValuesAtEachColumn[j+1])
                    previousTopVal = currentTopVal
        return min(psblValuesAtEachColumn)