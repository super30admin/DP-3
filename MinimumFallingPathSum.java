class MinimumFallingPathSum {
    
    //time : O(m*n) where m = num of rows and n=num of columns
    //space: O(1)
	//Did it run successfully on leetcode: yes
    public int minFallingPathSum(int[][] matrix) {
        //null case
        if(matrix == null || matrix.length==0 || matrix[0]==null || matrix[0].length==0) return 0;
        
        //looping through the matrix from the end
        for(int i=matrix.length-2; i>=0; i--){
            for(int j=0; j<matrix[0].length; j++){
                //if it is the element in first column, 
                //add min element between (elemnt below it and right elemnt below it) to current elemnt
                if(j==0) matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                 //if it is the element in the last column
                //add min element between (elemnt below it, left elemnt below) to current elemnt
                else if(j==matrix[0].length-1) matrix[i][j] += Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                //if it is the element in the middle
                //add min element between (elemnt below it, left elemnt below and right elemnt below) to current elemnt
                else matrix[i][j] += Math.min(matrix[i+1][j], Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
            }
        }
        int min = Integer.MAX_VALUE;
        //finding minimum elemnt in first row
        for(int i=0; i<matrix[0].length; i++){
            min = Math.min(min, matrix[0][i]);
        } 
        //return the min value
        return min;                              
    }
}