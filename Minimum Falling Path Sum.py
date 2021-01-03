class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        #Time Complexity: O(n**2) 
        #Space Complexity: O(1), since we just mutated the original matrix
        #where, n == A.length == A[0].length
        #Note: could have also used a length n list if mutating the original matrix
        #was not allowed
        #The space complexity would then be O(n)
        
        for row in range(len(A) - 2, -1, -1):
            #two edge cases
            A[row][0] += min(A[row + 1][:2])
            A[row][-1] += min(A[row + 1][-2:])
            
            for col in range(1, len(A[0]) - 1):
                A[row][col] += min(A[row + 1][col - 1 : col + 2])

        return min(A[0])