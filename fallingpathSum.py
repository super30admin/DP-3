"""931. Minimum Falling Path Sum
Time Complexity: O(mn)
Space Complexity: O(mn)"""
class Solution:
    def minFallingPathSum(self, arr: List[List[int]]) -> int:
        nrows = len(arr)
        ncols = len(arr[0])
        dp_arr = [[None for i in range(nrows)] for j in range(ncols)]
        dp_arr[0] = arr[0][:]
        print(dp_arr)
        for i in range(1, nrows):
            for j in range(ncols):
                if j == 0:
                    dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j + 1]) + arr[i][j]
                elif j == len(arr[0]) - 1:
                    dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j - 1]) + arr[i][j]
                else:
                    dp_arr[i][j] = min(dp_arr[i - 1][j], dp_arr[i - 1][j + 1], dp_arr[i - 1][j - 1]) + arr[i][j]
            print(dp_arr)
        return min(dp_arr[-1])

