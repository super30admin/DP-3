# Take a nxn arr with the same no. of rows and columns as the given matrix and 
# initialize it to 0 for rows and col. Assign the last row with the same values as 
# the original matrix. Take a loop from the second last row of the original matrix 
# until the first row. In each loop check if the elelmts of the arr's (row+1)th elements 
# with col-1,col and col+1 minimum value. Add the minimum value to the orginal loop element and store 
# it in the row th col th index of arr.

# Time complexity: O(nxn) n= num of rows and col
# Space complexity O(nxn)


class Solution(object):
    def minFallingPathSum(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        r=len(matrix)
        c=len(matrix[0])
        arr= [[0 for i in range(c)] for j in range(r)]
        for ind, i in enumerate(matrix[r-1]):
            arr[r-1][ind]=i
        x = r-2    
        while x>=0:
            for ind,i in enumerate(matrix[x]):
                lg=sm=arr[x+1][ind]
                if ind-1>=0:
                    sm=arr[x+1][ind-1]
                if ind+1<c:
                    lg=arr[x+1][ind+1]
                md=arr[x+1][ind]
                # print(lg,md,sm)
                mini=min(md, sm, lg)
                arr[x][ind]=mini+i
            x-=1
        # print(arr)
        return min(arr[0])





        
            
            





        