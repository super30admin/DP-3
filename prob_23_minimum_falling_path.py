# Dynamic Programming
# passed all test cases
# time complexity =O(n)
#space complexity=O(1)
# The approach here is to iterate the 2-D array from forward. Add the min value amoungst the available
# elements to add to the next row. keep on doing this until you reach the last row. and finally the
# minimum element sum in the last row indicates the correct minimum falling path.
class Solution(object):
    def minFallingPathSum(self, A): #A is matrix [[2,3,4],[5,5,6],[8,9,10]]
        #edge case
        self.A=A
        if self.A== [] or len(self.A) == 0: #i created an object instance of the same,so using self
            return 0
        for i in range(1,len(self.A)):
            for j in range(len(self.A[0])):
                if j == 0:
                    A[i][j] = min(A[i-1][j],A[i-1][j+1])+A[i][j]

                elif j == len(self.A[0])-1:
                    A[i][j] = min(A[i - 1][j], A[i - 1][j - 1]) + A[i][j]
                else:
                    A[i][j] = min(A[i - 1][j], A[i - 1][j + 1],A[i - 1][j - 1]) + A[i][j]
        return min(A[len(A)-1])




        #self.costs = costs
        last_1= A[0][0]

        last_2 = A[0][1]

        last_2 = A[0][2]

        for i in range(1,len(costs)):

            last_1,last_2,last_3 = min(last_1,last_2)+costs[i][0],min(last_red,last_green)+costs[i][1],min(last_blue,last_red)+costs[i][2]
        return min(last_blue,last_green,last_red)
v= Solution()
a=[[17,2,17],[16,16,5],[14,3,19]]
print(v.mincost(a))


