# Delete and Earn
#   Time Complexity : O(m*n)
#   Space Complexity : O(m*n)
#   Did this code successfully run on Leetcode : No, time limit exceeded
#   Any problem you faced while coding this : No



class Solution(object):
    def minFallingPathSum(self, cost):

        R,C=len(cost),len(cost)
        tc = [[float('inf') for x in range(C)] for x in range(R)]


        tc[0][0] = cost[0][0] 

        # Initialize first row of tc array 
        for j in range(1, R): 
            tc[0][j] = cost[0][j] 


        # Construct rest of the tc array 
        for i in range(1,R): 
            for j in range(R):
                if i>0 and j>0:
                    tc[i][j] = tc[i-1][j-1]
                if i>0:
                    tc[i][j]=min(tc[i][j],tc[i-1][j])
                if j<R-1 and i>0:
                    tc[i][j]=min(tc[i][j],tc[i-1][j+1])
                tc[i][j]+=cost[i][j] 
        # print tc
        return min(tc[-1])  