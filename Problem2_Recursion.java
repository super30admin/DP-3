/**
LeetCode Submitted : NA (Recursive solution)
Time Complexity : O(2^N)
Space Complexity : O(2^N)

The idea is to replicate house paint problem and populate min across each position by referring to available sum in previous row by handling boundary conditions
We will recursively traverse all possible decisions at each subtree
**/


class Solution {
    public int minFallingPathSum(int[][] A) {
     
        if(A == null || A.length == 0)
            return 0;
        
        int row = A.length;
        int column = A[0].length;
        
        int min  = 99999;
       
        //i = 0 and j = 0
        for(int col = 0;col <column; col++){ 
            int out = decision(A,0,col,0);
            if(out < min)
                min = out;
        }
        
        return min;
            
    }
    
    int decision(int[][]A,int start,int end,int min){ //end = i and start = j
        if(start == A.length){
            return min;
        
        }
            
        if(end == 0){
            return Math.min(decision(A,start+1,end+1,min + A[start][end]),decision(A,start+1,end,min + A[start][end]));
        }else if(end == A[0].length -1){
            return Math.min(decision(A,start+1,end-1,min + A[start][end]),decision(A,start+1,end,min + A[start][end]));
        }else{
            return Math.min(decision(A,start+1,end,min + A[start][end]),Math.min(decision(A,start+1,end -1,min + A[start][end]),decision(A,start+1,end+1,min+A[start][end])));    
        }
        
        //return 0;    
    }
}
