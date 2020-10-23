# Time Complexity:- O(n*i), n=len(A),i=len(A[0])
# Space Complexity:- O(n*i)
# Approach:- At every point we have 3 options for the next row, we can either taken column-1,column+1,column,
# The mincost is taking the cost of the current-row,column and adding that to the min of the three choices we have.
# Base Case:- Extremely tricky, to keep it inside the bounds we dont want n or i to go out of bounds, here n or i can 
# individually go out of bounds so I kept i inside the bounds inside the recursion and n inside the bounds in the base case.
import sys

class Solution:
    def minFallingPathSum(self, A):
        @lru_cache(maxsize=None)
        def mps(n,i):
            # keep n inside bounds
            if n==len(A)-1:
                return A[n][i]
            sum1=sys.maxsize
            # if i-1>0 then we have three options for the next row-column,column+1,column-1
            if i-1>=0:
                # column+1 can go out of bounds check and return infinity if it does
                sum1=A[n][i]+min(mps(n+1,i-1),mps(n+1,i),mps(n+1,i+1) if i+1<len(A[0]) else sys.maxsize)
            # if i-1<0 then we have two options for the next row-column,column+1
            sum2=A[n][i]+min(mps(n+1,i),mps(n+1,i+1)if i+1<len(A[0]) else sys.maxsize)
            return min(sum1,sum2)
        global_min=sys.maxsize
        for i in range(len(A[0])):
            local_min=mps(0,i)
            global_min=min(global_min,local_min)
        return global_min
    
