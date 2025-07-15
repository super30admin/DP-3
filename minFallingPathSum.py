# Time Complexity:O(n*2)
# Space Complexity:O(n)
# Approach:
# start form bottom and draw tree you will understand there are a lot of same sub problems at midlle elements you have 3 choices at border elements you have 2 chocies.
# should take care of prev if trying to optiize space.
# We will start form bottom and try to fillup our dp array we always take min dp[i] states min value if thats starting point*

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        c,r=len(matrix),len(matrix[0])
        dp=[0 for i in range(r)]  #[m][n]
        ans=float('inf')
        #start filling from bottom
        for i in range(r):
           dp[i]= matrix[c-1][i]
        
        for col in range(c-2,-1,-1):
            #r==0 or r==r-1
            #3 cases
            # print(dp)
            for row in range(r-1,-1,-1):
                if row==0 :
                    dp[row]=min(matrix[col][row]+dp[row],matrix[col][row]+prev)
                elif  row== r-1:
                    prev=dp[row]
                    dp[row]=min(matrix[col][row]+dp[row],matrix[col][row]+dp[row-1])

                else:
                    t=dp[row]
                    dp[row]=min(matrix[col][row]+dp[row],matrix[col][row]+dp[row-1], matrix[col][row]+prev)
                    prev=t
        for i in dp:
            ans=min(ans,i)
        # print(dp)
        return ans
            

