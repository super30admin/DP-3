# I solved this problem by defining a grid and then wrting 3 cases for first column, mid columns and last column, we need minimum element so suppose for 4 it will be 4+2 or 4+3 it should be 4+2 as its minimum, I defined both other cases in such way that I find minimum and then write that in the matrix of dp
# Time Complexity: O(m*n)
#Space Complexity: O(n*m)
def pathSum(arr):
    dp  = dp = [[0 for i in range(len(arr))] for j in range(len(arr[0]))]
    for i in range(len(arr)):
        for j in range(len(arr[0])):
            if (j==0):
                dp[i][j] = arr[i][j] + min(dp[i-1][j],dp[i-1][j+1])
            elif (j==len(arr[0])-1):
                dp[i][j] = arr[i][j] + min(dp[i-1][j],dp[i-1][j-1])
            else:
                dp[i][j] = arr[i][j] + min(dp[i-1][j],dp[i-1][j-1],dp[i-1][j+1])
    return min(dp[len(dp)-1])


arr = [[1,2,3],[4,5,6],[7,8,9]]
min = pathSum(arr)
print(min)