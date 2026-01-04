# Problem1: (https://leetcode.com/problems/delete-and-earn/)
# Time Complexity : 
## CASE 1 : O(2^n) where n in length of nums
## CASE 2 : O(N) where n in the length of nums
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

## starting with the exaustive approach
## here since we dont know how many total items will be there for each element we might have to create freqMap
## then sort it in order to traverse it, but a better way would be to get the range, get the max,
## create an array from 0->max and iterate iver nums to fill the frequency 
## Once we have the rangearr we can either choose to select ith and i+2 or go with i+1. this essentially becomes
## house rober, creating a helper function to recursively call and choose and not choose and returning the max of it
# CASE 1 : exuastive search
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mx = -99999
        for i in range(len(nums)):
            mx = max(mx,nums[i])

        rangearr = [0] * (mx+1) 

        for i in range(len(nums)):
            rangearr[nums[i]] +=1

        def helper(rangearr,idx):
            ## base case
            if idx >= len(rangearr):
                return 0
            ## choose the num
            case1 = idx* rangearr[idx] + helper(rangearr,idx+2)
            ## do no choose the num 
            case2 = helper(rangearr,idx+1)

            res = max(case1,case2)
            return res


        maxPoints = helper(rangearr,0)
        return maxPoints

# CASE 2: memoization

## the idea is similar to previous one, but previous will give TLE, so we can memoization
## create a new memo 2d array and just check if the item we want to calculate already exist in memo
## if yes return else continue
## this will bring the time down to O(N) from exponential
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        mx = -99999
        for i in range(len(nums)):
            mx = max(mx,nums[i])

        rangearr = [0] * (mx+1) 

        for i in range(len(nums)):
            rangearr[nums[i]] +=1

        def helper(rangearr,idx):
            ## base case
            if idx >= len(rangearr):
                return 0
            if memo[idx] != -1:
                return memo[idx]
            ## choose the num
            case1 = idx* rangearr[idx] + helper(rangearr,idx+2)
            ## do no choose the num 
            case2 = helper(rangearr,idx+1)

            res = max(case1,case2)
            memo[idx] = res
            return res

        memo = [-1]* len(rangearr)
        maxPoints = helper(rangearr,0)
        return maxPoints


# Problem2: (https://leetcode.com/problems/minimum-falling-path-sum/)
# Time Complexity : O(N)
# Space Complexity : O(MN)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this :no

## the idea is simple here, start with exaustive and add memoization to it
## starting from each col at row 0, since it is not mentioned we can only start at 0,0
## after choosing each element , checking the three cases which gives min to select the next element
## and continuing the process, without the memoization this will give TLE, 
## adding a 2d array to store the values which have already been calculated
## Here point to note is initializing memo with -1 wont work becuase the matrix itself can have -1 and memoization will fail
## initializing with None will work here
class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        rows= len(matrix)
        cols = len(matrix[0])

        def helper(matrix,i,j):
            ##base case 
            if i>=rows or j<0 or j>= cols:
                return float('inf')
            if i == rows-1:
                return matrix[i][j]
            if memo[i][j] is not None:
                return memo[i][j]
            ## case 1 to choose row+1,col-1
            case1 = matrix[i][j] + helper(matrix, i+1, j-1)
            ## case 2 to choose row+1,col
            case2 = matrix[i][j] + helper(matrix, i+1, j)
            ## case 3 to choose row+1,col+1
            case3 = matrix[i][j] + helper(matrix, i+1, j+1)
            
            ## getting min of three cases, since we want min cost
            res = min(case1,min(case2,case3))
            memo[i][j] = res
            return res

        memo = [[None] * (cols) for _ in range(rows)]

        minSum = float('inf')


        ## iterating over all the element of 0th row , potentially all of them can be starting point
        for j in range(cols):
            value = helper(matrix,0, j)
            minSum = min(minSum, value)

        return minSum