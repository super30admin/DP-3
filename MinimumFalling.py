class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if(i-1>0 and j+1>0 and j+1<len(A[i])and i-1<len(A[i])):
                    A[i][j]+=min(A[i-1][j],A[i-1][j+1])
                elif (i-1>0 and j-1>0 and j-1<len(A[i]) and i-1<len(A[i])):
                    A[i][j]+=min(A[i-1][j],A[i-1][j-1])
                elif i-1>0 and j-1>0 and j+1>0 and j-1<len(A[i]) and i-1<len(A[i]) and j+1<len(A[i]):
                    A[i][j]+=min(A[i-1][j],A[i-1][j+1],A[i-1][j-1])
        return min(A[len(A)-1])
        
#It's giving wrong answer on Leetcode for standard input, my answer is 11, it should be 12! Please tell why? Thanks
