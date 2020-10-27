"""
Time Complexity O(N^2)
Space Conplexity O(1)

"""


class Solution_R:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if (A is None or len(A)==0):
            return 0
        n=len(A)
        ans=float('inf')
        for i in range(len(A[0])):
            j=1
            ans=min(ans,self.findmin(A[0][i],j,i,A))
        
        return ans
        
    def findmin(self,minsum,r,c,A):
        #base
        if(r>=len(A)):
            return minsum
        left=None
        right=None
        #logic
        if c-1>=0:
            left=self.findmin(minsum+A[r][c-1],r+1,c-1,A)
        
        middle=self.findmin(A[r][c]+minsum,r+1,c,A)
        if c+1<len(A[0]):
            right=self.findmin(A[r][c+1]+minsum,r+1,c+1,A)
        m=middle
        if left is not None:
            m=min(left,m)
        if right is not None:
            m=min(m,right)
        return m
        