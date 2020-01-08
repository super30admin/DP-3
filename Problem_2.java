
public class Problem_2 {

public int minFallingPathSum(int[][] A) {
        
        if(A == null || A.length == 0){
            return 0;
        }
        
        for(int i=1; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);    
                }else if(j == A[0].length - 1){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j-1]);    
                }else{
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], Math.min(A[i-1][j-1], A[i-1][j+1]));    
                }      
            }
        }
                                                 
        int min = Integer.MAX_VALUE;
        int l = A.length - 1;
        for(int i=0; i<A[0].length; i++){
            if(A[l][i] < min){
                min = A[l][i];
            }
        }
        
        return min;
                                        
    }
}
