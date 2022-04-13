#minimum falling path sum


# // Time Complexity : O(n^2) n=matrix
# // Space Complexity :O(n^2)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no, it was very similar to the house painting problem



def minFallingPathSum(nums):
    dp = [[0 for i in range(len(nums[0]))] for j in range(len(nums))]

    for i in range(len(nums[0])):
        dp[0][i] = nums[0][i]                                   #copy the first row of the matrix

    for i in range(1, len(nums)): 
        for j in range(len(nums[0])):
            if j==0:                                                                #if its the first column find the min between the one above or the one diagonal to the right and add that to the current one
                dp[i][j] = nums[i][j] + min(dp[i-1][0],dp[i-1][1])
            elif j==len(nums[0])-1:                                                  #if its the last column find the min between the one above or the one diagonal to the left and add that to the current one
                dp[i][j] = nums[i][j] +  min(dp[i-1][j],dp[i-1][j-1])
            else:                                                                   #else, find the min between the one on top, left, and right diagonal and add that to the currrent
                dp[i][j] = nums[i][j] + min(dp[i-1][j],dp[i-1][j-1], dp[i-1][j+1])
        
    return min(dp[len(nums)-1])


#test
print(minFallingPathSum([[2,1,3],[6,5,4],[7,8,9]]))