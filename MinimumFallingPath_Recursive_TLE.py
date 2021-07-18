class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        if not matrix or len(matrix) == 0: 
            return 0
        
        self.mini_sum = sys.maxsize
        
        next_falling_elem = [(1,-1), (1, 0), (1,1)]
        
        for i in range(len(matrix[0])): 
            self.recurse(matrix, matrix[0][i], 0, i, next_falling_elem)
        
        return self.mini_sum
            
    
    def recurse(self, matrix, curr_sum, i, j, next_falling_elem): 
#         base 
        if i == len(matrix[0]) - 1: 
            self.mini_sum = min(self.mini_sum, curr_sum)
            return

#         logic
        for x,y in next_falling_elem:
            new_x = i + x
            new_y = j + y 
            
            if new_x >= 0 and new_x < len(matrix) and new_y >= 0 and new_y < len(matrix[0]):
                temp_sum = curr_sum + matrix[new_x][new_y]
                self.recurse(matrix, temp_sum, new_x, new_y, next_falling_elem)
        
