# DP-3

## Problem1: (https://leetcode.com/problems/delete-and-earn/)

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if nums == [] or len(nums)==0:
            return 0
        maxx = max(nums)+1
        arr = []
        arr = [0 for i in range(maxx)] 
        for i in nums:
            arr[i] = arr[i] + i
        skip = 0
        take = arr[0]
        for i in range(len(arr)):
            temp = skip
            skip = max(take,skip)
            take = temp+arr[i]
        return max(skip,take)
    
    <!-- #Time Complexity: O(n) n - avg length of the array
    #Space Complexity: O(n) n - avg length of the 2d array
    #Approach: Dynamic programming.  -->
            
                
        


## Problem2 (https://leetcode.com/problems/minimum-falling-path-sum/)

class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) == 0 or matrix == []:
            return 0
        for i in range(1,len(matrix)):
            for j in range(len(matrix[0])):
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j+1])
                elif j == len(matrix)-1:
                    matrix[i][j] += min(matrix[i-1][j], matrix[i-1][j-1])
                else:
                    matrix[i][j] += min(matrix[i-1][j-1],matrix[i-1][j], matrix[i-1][j+1])
        minim = float('inf')
        for i in range(len(matrix)):
            minim = min(minim,matrix[len(matrix)-1][i])
        return minim  
            
    <!-- #Time Complexity: O(mn) m - no. of rows. n - no of cols
    #Space Complexity: O(1) matrix given in the question is manipulated/mutated
    #Approach: Dynamix programming mixed with greedy algorithm to choose the minimum in the previous row.  -->
        
        
