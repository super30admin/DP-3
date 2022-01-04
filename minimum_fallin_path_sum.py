# tc : O(mn), m rows, n columns
# sc  O(n)
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if len(matrix) ==0 :
            return 0
        min_arr = [matrix[len(matrix)-1][j] for j in range(len(matrix[0]))]
        print(min_arr)
        for i in range(len(matrix) -2 , -1, -1):
            copy_min_arr = [min_arr[j] for j in range(len(min_arr))]
            for j in range(len(min_arr)):
                ele = matrix[i][j]
                if ( j == 0 ):
                    ele = ele + min( min_arr[j], min_arr[j +1])
                    
                elif ( j == (len(min_arr) - 1) ):
                    ele = ele + min( min_arr[j], min_arr[j -1])    
                    
                else:
                    ele = ele + min( min_arr[j], min_arr[j +1], min_arr[j -1])
                copy_min_arr[j] = ele
            min_arr = [copy_min_arr[j] for j in range(len(copy_min_arr))]
            print(min_arr)
            
        return min(min_arr)     
                
        