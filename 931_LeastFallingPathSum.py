# time complexity: O(m*n) 
# m = num of rows, n = num of col
# space complexity:  O(1)



class Solution:
    def minFallingPathSum(self, matrix) -> int:             
        if(matrix == None or len(matrix) == 0): 
            return 0
        
        for i in range(len(matrix)-2, -1, -1):
            for j in range(len(matrix[0])):

                # if particular number is placed at 0th column then ,it will check for minimum between matrix[row+1][0] and matrix[row+1][1] and add that min with it
                if j == 0:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j+1])

                # if particular number is placed at nth column then ,it will check for minimum between matrix[row+1][n-1] and matrix[row+1][n] and add that min with it
                elif j == len(matrix[0]) - 1:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1])

                # for other cases it will check minimum between matrix[row+1][col],matrix[row+1][col-1],matrix[row+1][col-1] and that min with it
                else:
                    matrix[i][j] += min(matrix[i+1][j], matrix[i+1][j-1], matrix[i+1][j+1])

        # intially set min with infinity
        res = 99999 
        for j in range(len(matrix[0])):

            # this will find min between the values of 1st row of updated matrix
            res = min(res, matrix[0][j])

        return res

        

obj = Solution()
print(obj.minFallingPathSum([[-19,57],[-40,-5]]))