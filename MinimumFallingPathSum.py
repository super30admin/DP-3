class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        # Dynamic Programming Bottom Up Approach
        # Time Complexity is O(n2)
        # Space Complexity is O(1), since we're using the same input array
        for i in range(len(matrix)-1,0,-1):
            for j in range(len(matrix[0])):
                low = max(0,j-1)
                high = min(len(matrix),j+2)
                minVal = min(matrix[i][low:high])
                matrix[i-1][j] += minVal
        return min(matrix[0])