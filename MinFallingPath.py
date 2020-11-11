class Solution(object):
    
    solutions = {}
    matrix = []
    row = -1
    cols = -1
    
    def get_neighbours(self,prev_col) :
        neighbours = []
        if prev_col == -1 :
            neighbours = range(self.cols)
        else :
            neighbours = [prev_col-1, prev_col, prev_col+1]

        for i in neighbours:
            if (i >= 0) and (i < self.cols):
                yield i 
    
    def get(self,row,prev_col) :
        if self.solutions.get(row) and (self.solutions[row].get(prev_col) != None) :
            return self.solutions[row].get(prev_col)
        return None
    
    def put(self,row,prev_col,min_path) :
        if not self.solutions.get(row):
            self.solutions[row] = {}
        self.solutions[row][prev_col] = min_path
        
    
    def helper(self,prev_col,row):
        if self.get(row,prev_col) :
            return self.get(row,prev_col)
        
        if row == (self.row -1) :
            min_path = float("Inf") 
            for i in self.get_neighbours(prev_col):
                r= self.matrix[row][i]
                if r < min_path :
                    min_path = r 
            self.put(row, prev_col,min_path)
            return min_path
        else :
            min_path = float("Inf") 
            for i in self.get_neighbours(prev_col):
                r = self.helper(i,row+1) + self.matrix[row][i]
                if r < min_path :
                    min_path = r 
            self.put(row, prev_col,min_path)
            return min_path
    
    def fallingPath(self, matrix) :
        self.matrix = matrix
        self.row = len(matrix)
        self.cols = len(matrix[0])
        self.solutions = {}
        return self.helper(-1,0)
    
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        return self.fallingPath(A)
