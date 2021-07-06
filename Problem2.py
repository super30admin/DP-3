"""
// Time Complexity : mentioned in the code for different approaches
// Space Complexity : mentioned in the code for different approaches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no but haven't got the hang of DP yet 

// Your code here along with comments explaining your approach
"""
class Solution(object):
    """
    FOR RECURSIVE SOLUTION
    def helper(self, A, r, c, min_val):
        #base
        if r >= len(A)-1: #if traversed all the rows, return the min_val
            return min_val

        #logic
        case_down = 99999 #infinity
        case_right = 99999
        case_left = 99999
        
        case_down = self.helper(A, r+1,c, min_val + A[r+1][c]) #for value just below
        
        if c>=1:
            case_left = self.helper(A, r+1,c-1, min_val+ A[r+1][c-1]) #if left exists in next row, recursive call on that
            
        if c<len(A)-1:
            case_right = self.helper(A, r+1,c+1, min_val+ A[r+1][c+1]) #if right exists in next row, recursive call on that
            
        #print min(case_down, case_left, case_right)
        return min(case_down, case_left, case_right) #return minimum of the three cases
        """
    
    def minFallingPathSum(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        
        """
        RECCURSION
        Time complexity: (3^n)*n, n = number of rows or columns, not sure 
        Space complexity: 0(n), not sure  

        res = []
        for i in range(len(A)):
            res.append(self.helper(A,0, i,A[0][i])) #calling helper for all columns in 0th row, with min value = current value 
        #print res   
        return min(res) 
        """
        
        
        """
        DP SOLUTION

        Time complexity: n^2, since its a square matrix
        Space complexity: o(1), no auxilary data structure
        """
        
        for i in range(1, len(A)): #starting from the 2nd row at 1st index
            for j in range(len(A)):
                left = 99999
                right = 99999
                
                if j >= 1:
                    left = A[i][j]+A[i-1][j-1] #if left exists in prev row, calculating value by considering it 

                if j < len(A)-1:
                    right = A[i][j]+A[i-1][j+1] #if right exists in prev row, calculating value by considering it
                    
                up = A[i][j] + A[i-1][j] # calculating value by considering valu just above   
                
                A[i][j] = min(left, right, up) #finding the minimum value out of the 3 and updating A[i][j]
                
        return min(A[-1])
