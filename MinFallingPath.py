'''
    Time Complexity:
        O(n*2) (where n = width of the array)

    Space Complexity:
        O(n*2) (where n = width of the array)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        -> For each element in the first row, go down in three directions:
            1. Diagonally left (row + 1, col - 1)
            2. Straight (row + 1, col)
            3. Diagonally right (row + 1, col + 1)
        -> Take the mini of these three answers.
        -> Memoize it.
'''
MAX_INT = sys.maxsize

class Solution:
    def __init__(self):
        self.A = []
        self.dp = {}

    def minFallingPathSum(self, A: List[List[int]]) -> int:
        self.A = A
        mini = MAX_INT
        for j in range(len(self.A)):
            mini = min(mini, self.find_max_fall(0, j))

        return mini

    def find_max_fall(self, row, col):
        if row < 0 or row >= len(self.A):
            return MAX_INT

        if col < 0 or col >= len(self.A[row]):
            return MAX_INT

        if (row, col) in self.dp:
            return self.dp[(row, col)]

        self.dp[(row, col)] = self.A[row][col]
        left = self.find_max_fall(row+1, col-1)
        center = self.find_max_fall(row+1, col)
        right = self.find_max_fall(row+1, col+1)
        mini = min(left, center, right)
        if mini != MAX_INT:
            self.dp[(row, col)] += mini
        return self.dp[(row, col)]
