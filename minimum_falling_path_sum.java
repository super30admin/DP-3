//TC - O(mn)
//SC - O(mn)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][]arr = new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(arr[i],-1);
        }
        int ans = 1000001;
        for(int i=0;i<n;i++){
            ans = Math.min(ans,minSum(0,i,m,n,matrix,arr));
        }
        return ans;
    }
    
    public int minSum(int cr,int cc,int m,int n, int[][]matrix,int[][] arr){
        
        if(cr<0 ||cr>=m || cc<0 || cc>=n) return 1000001;
        
        if(cr==m-1) return matrix[cr][cc];
        
        if(arr[cr][cc]!=-1) return arr[cr][cc];
        
        int down = matrix[cr][cc]+ minSum(cr+1,cc,m,n,matrix,arr);
        int ld = matrix[cr][cc]+ minSum(cr+1,cc-1,m,n,matrix,arr);
        int lr = matrix[cr][cc]+ minSum(cr+1,cc+1,m,n,matrix,arr);
        
        int temp = Math.min(down,lr);
        
        arr[cr][cc] = Math.min(temp,ld);
        
        return arr[cr][cc];
        
        
    }
}