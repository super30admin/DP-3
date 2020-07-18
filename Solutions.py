'''
PROBLEM 1

TIME COMPLEXITY: O(max(Nums))
SPACE COMPLEXITY: O(max(Nums))

- create a new array arr where index denotes the numbers in nums and arr[i] denotes the number of times it appear in nums
- create a matrix dp[][]  of size max(nums)*2 where coloumn dp[i][0] denotes the maximum earn until that point if we dont choose arr[i] and dp[i][1] denotes the max earn if we choose arr[i]
- the answer will be maximum of dp[len(nums)][0] and dp[len(nums)][1]

'''

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums)==0:
            return 0
        arr=[ 0 for i in range(max(nums)+1)]
        print(arr)
        
        for i in nums:
            arr[i]+=1
            
        print(arr)
        
        dp=[[0 for i in range(2)] for j in range(max(nums)+1)]
       
        i=0
        for i in range(1, len(dp)):
            dp[i][0]= max(dp[i-1][0], dp[i-1][1])
            dp[i][1]= arr[i]*i + dp[i-1][0]
        print(dp)
        return max(dp[i][0],dp[i][1])

'''
PROBLEM 2

TIME COMPLEXITY: O(len(A))
SPACE COMPLEXITY: O(1)

- we proceed with updating the values in array with minimum path at that point 
- traverse the entire array calculating least cost of the path according to goven constraints of shifting coloumn by atmost 1
- the answer will be maximum of last row of the matrix

'''

        class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        i=0
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if j==0:
                    A[i][j]+= min(A[i-1][j], A[i-1][j+1])
                elif j==len(A[0])-1:
                    A[i][j]+= min(A[i-1][j-1], A[i-1][j])
                else:
                    A[i][j]+= min(A[i-1][j-1], A[i-1][j],A[i-1][j+1])

        return min(A[i])
                    