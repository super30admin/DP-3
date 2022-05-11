// Time Complexity :O(m*n)
// Space Complexity :O(1)
public class MinimumFallingPath {

        public int minFallingPathSum(int[][] arr) {
            for(int i=arr.length-2;i>=0;i--){
                for(int j=0;j<arr[i].length;j++){
                    if(j==0)arr[i][j]=arr[i][j]+Math.min(arr[i+1][j],arr[i+1][j+1]);
                    else if(j==arr[i].length-1)arr[i][j]=arr[i][j]+Math.min(arr[i+1][j],arr[i+1][j-1]);
                    else{
                        arr[i][j]=arr[i][j]+Math.min(arr[i+1][j],Math.min(arr[i+1][j-1],arr[i+1][j+1]));
                    }
                }
            }
            
            int max=Integer.MAX_VALUE;
            for(int i=0;i<arr[0].length;i++){
                if(max>arr[0][i])max=arr[0][i];
            }
            return max;
            
        }
    
}
