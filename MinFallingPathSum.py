// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if len(A[0])==0 or len(A)==0 :
            return 0
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if j==0:
                    A[i][j]+= min(A[i-1][j],A[i-1][j+1]) #if index is first element, at most minimum of 2 options can be found
                elif j==len(A[0])-1:
                    A[i][j]+= min(A[i-1][j],A[i-1][j-1]) #if index is last element, at most minimum of 2 options can be found
                
                else:
                    A[i][j]+= min(min(A[i-1][j],A[i-1][j+1]),A[i-1][j-1]) # else ,we have 3 options to choose form
        return min(A[len(A)-1]) # all minimum sum will be accumulated in the last array, return minimum among that