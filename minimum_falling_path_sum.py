'''
Solution 1: Recursion 
At each root node, explore 3 possibilities in the next row. Height of tree = number of rows.
At each level, we expand 3 possibilities (diag left, below, diag right). Starting in the
first row, we build similar trees for total elements in the columns.
Time Complexity: O(m * 3^n), n = number of rows, m = number of cols
Space Complexity: O(1)
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        self.rows = len(matrix)
        self.cols = len(matrix[0])
        ans = 2**31 # inf
        
        for col in range(self.cols):
            sum_from_this_root=self.helper(matrix,0,col)
            ans = min(ans,sum_from_this_root)
        
        return ans
    
    def helper(self,matrix,row_idx, col_idx):
        # base
        if row_idx==self.rows:
            return 0

        #logic
    
        #maintain a minimum sum for this root
        min_sum_curr_root = 2**31 #act as inf
        
        # for this root, explore the next row with 3 possible cols. diag left, below, diag right
        for next_col in range(-1,2): #-1,0,1
            if 0<=col_idx+next_col<self.cols: #sanity check
                curr_path_sum = matrix[row_idx][col_idx]+self.helper(matrix,row_idx+1,col_idx+next_col)
                min_sum_curr_root = min(min_sum_curr_root,curr_path_sum)
        
        return min_sum_curr_root

'''
Solution 2: Recursion + Memoization 
At each root node, explore 3 possibilities in the next row. Height of tree = number of rows.
At each level, we expand 3 possibilities (diag left, below, diag right). Starting in the
first row, we build similar trees for total elements in the columns.
Time Complexity: O(m * n), n = number of rows, m = number of cols
Space Complexity: O(m * n)
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        self.rows = len(matrix)
        self.cols = len(matrix[0])
        self.mem = {} # memoization
        ans = 2**31 # inf
        
        for col in range(self.cols):
            sum_from_this_root=self.helper(matrix,0,col)
            ans = min(ans,sum_from_this_root)
        
        return ans
    
    def helper(self,matrix,row_idx, col_idx):
        # base
        if row_idx==self.rows:
            return 0

        if (row_idx,col_idx) in self.mem:
            return self.mem[(row_idx,col_idx)]

        #logic
    
        #maintain a minimum sum for this root
        min_sum_curr_root = 2**31 #act as inf
        
        # for this root, explore the next row with 3 possible cols. diag left, below, diag right
        for next_col in range(-1,2): #-1,0,1
            if 0<=col_idx+next_col<self.cols: #sanity check
                curr_path_sum = matrix[row_idx][col_idx]+self.helper(matrix,row_idx+1,col_idx+next_col)
                min_sum_curr_root = min(min_sum_curr_root,curr_path_sum)
        
        self.mem[(row_idx,col_idx)] = min_sum_curr_root
        return min_sum_curr_root

'''
Solution 3: DP 
At each root node, explore 3 possibilities in the next row.
Starting from second last row, for each col, update dp with curr col costs + minimum
of (diag left, below, diag right) from next row in DP_MAT which has already been explored.
Time Complexity: O(m * n), n = number of rows, m = number of cols
Space Complexity: O(m * n)
'''
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        
        dp_mat = [[None]*cols for i in range(rows)]

        # copy the last row in dp
        for j in range(cols):
            dp_mat[-1][j] = matrix[-1][j]

        for row_idx in range(rows-2,-1,-1): #reverse row iteration | okay to skip the last row
            for col_idx in range(cols):
                min_sum_curr_root = 2**31
                for k in range(-1,2): # -1,0,1
                    if 0<=col_idx+k<cols: 
                        curr_path_sum = matrix[row_idx][col_idx] + dp_mat[row_idx+1][col_idx+k]
                        min_sum_curr_root = min(min_sum_curr_root,curr_path_sum)
                dp_mat[row_idx][col_idx] = min_sum_curr_root

        return min(dp_mat[0]) 

    