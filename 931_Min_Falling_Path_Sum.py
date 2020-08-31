# Leetcode problem link : https://leetcode.com/problems/minimum-falling-path-sum/
# Time Complexity : O(n)
#  Space Complexity : O(1)
#  Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Basic approach : 1. O(2^n) => form a tree for each num for the first row and and the next two/three options for the second num and third num, so on and so forth. Once we have reached the last row or leaf nodes, we have the total cost for each permutation and we can choose the min cost path after exploring all the nodes hence time complexity is 2^n for the tree but 3^n for the first node
        2. Recursively calculate cost for each subtree (without creating tree node) using memoization by storing cost corresponding to  number. Complexity will be O(n) here as we calculate cost for each number and only once but store in a dictionary which needs O(n) space

        Optimized approach: DP in O( n ) => Start from the second row /second last row and add to the current sum, the sum from previous row/last row for the possible options i.e. for first element in the row, possible options are element above and next to the element above it. For last num the options are element above it and element prev to the element above it. For all the numbers in between the options are num above and its neighbors. At each point keep calculating the sum with min value. Once we have reached the last row we return the min of the last row.
        
'''
class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        
        l = len(A)
        # Edge case when array is empty
        if not A or l == 0:
            return 0
        # Edge case when there is only one element, it will be the min elemenet
        if l == 1:
            return self.getMin(A[0])
        # Start traversing from the second row
        for i in range(1,l):
            for j in range(l):
                # If its the first element, only consider above it and next to it
                if j == 0:
                    A[i][j] += min(A[i-1][j], A[i-1][j+1])
                # If last element then consider element above it and previous to it
                elif j == l - 1:
                    A[i][j] += min(A[i-1][j], A[i-1][j-1])
                # for all the elements in between take min of the element above it and its neighbors
                else:
                    A[i][j] += min(A[i-1][j-1], A[i-1][j], A[i-1][j+1])
        # return min of last row
        return self.getMin(A[l-1])
   
# function to get min from the row
    def getMin(self,nums):
        min_val = float(inf)
        for num in nums:
            if min_val > num:
                min_val = num
        return min_val
        