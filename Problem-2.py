"""
Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)
Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.



Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation:
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.



Note:

1 <= A.length == A[0].length <= 100
-100 <= A[i][j] <= 100

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


"""
def Minimum_Path(A):
    if len(A)==0:    # check if length of given array of integers is 0 or not if 0 return 0
        return 0
    # create dp matrix with alL 0s, [0]*len(A[0]) for cols and len(A) for rows
    dp=[[0]*len(A[0]) for i in range(len(A))]

    for i in range(len(A[0])):  #copy first row of given matrix into dp matrix
        dp[0][i]=A[0][i]

    for i in range(1,len(A)):
        for j in range(len(A[0])):
            if j==0:     # if we pick first element in any row
                dp[i][j]=A[i][j] + min(dp[i-1][j], dp[i-1][j+1])

            elif j==len(A[0])-1: # if we pick last element in any row
                dp[i][j] = A[i][j] + min(dp[i - 1][j], dp[i - 1][j-1])

            else:  # if we pick any element beyond first and last element in any row
                dp[i][j] = A[i][j] + min(dp[i - 1][j], dp[i - 1][j - 1], dp[i-1][j+1])

    return min(dp[-1])   # return minimum from last row, which will be our minimum falling path sum


print(Minimum_Path([[1,2,3],[4,5,6],[7,8,9]]))












