

#delete and earn 
# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
# make a dictionary to record the sum of a number, add it to an array and then follow house robber pattern 

def deleteAndEarn(self, nums: List[int]) -> int:

        points = defaultdict(int)
        max_num = 0
        for num in nums:
            points[num] += num
            max_num = max(max_num,num)
        maxpoints = [0] * (max_num +1)
        maxpoints[1] = points[1]
        for i in range(2, len(maxpoints)):
            maxpoints[i] = max(maxpoints[i-1], maxpoints[i-2] + points[i])
        return maxpoints[-1]


#min falling path sum 
# Time Complexity : O(N^2)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO
# made a 2d array and itarte backwards to record minumum sum needed up till a aparticular points 
def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m-2,-1,-1):
            for j in range(0,n):
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])
                elif j == n - 1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])
                else:
                    matrix[i][j] += min(matrix[i+1][j+1], min(matrix[i+1][j], matrix[i+1][j-1]))
        return min(matrix[0])





