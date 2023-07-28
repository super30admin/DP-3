class Solution:
    def minFallingPathSum(self, costs: List[List[int]]) -> int:
        dp_matrix=[[None for i in range(len(costs[0]))] for i in range(len(costs))]
        for i in range(len(dp_matrix[0])):
            dp_matrix[-1][i]=costs[-1][i]

        for i in range(len(costs)-2,-1, -1):
            for j in range(len(dp_matrix[0])):
                if(j>0 and j<len(dp_matrix)-1):
                    dp_matrix[i][j]=min(dp_matrix[i+1][j-1], dp_matrix[i+1][j], dp_matrix[i+1][j+1])+costs[i][j]
                else:
                    if(j==0):
                        dp_matrix[i][j]=min(dp_matrix[i+1][j], dp_matrix[i+1][j+1])+costs[i][j]
                    else:
                        dp_matrix[i][j]=min(dp_matrix[i+1][j-1], dp_matrix[i+1][j])+costs[i][j]
        return min(dp_matrix[0])
        pass