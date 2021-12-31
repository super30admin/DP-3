"""
Given an n x n array of integers matrix, return the minimum sum
 of any falling path through matrix.

A falling path starts at any element in the first 
    row and chooses the element in the next row that is either
    directly below or diagonally left/right. Specifically, the next element
    from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).


// Time Complexity : ON^2
// Space Complexity :O1
// Did this code successfully run on Leetcode : not yet
// Any problem you faced while coding this :



"""
class Solution(object): 
    def minFallingPathSum(self, arr: list[list[int]]) -> int:
        n = len(arr)
        for i in range(1, n):
            for j in range(0, n):
                if j == 0:
                    arr[i][j] = min(arr[i-1][j], arr[i-1][j+1]) + arr[i][j]
    #work in progress
