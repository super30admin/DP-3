// Time Complexity: O(n*m) n and m are matrix dimensions
// Space Complexity: O(n) n is the total columns in matrix

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int [] arr = new int[matrix[0].length];
        int temp = 0;
        for (int i=0; i < matrix[0].length; i++){
            arr[i] = matrix[0][i];
        }
        // System.out.println(Arrays.toString(arr));
        for (int i = 1; i < matrix.length; i++){
            int [] temparr = Arrays.copyOf(arr, matrix[0].length);
            // int [] temparr = arr.clone();
            for(int j = 0; j < matrix[0].length; j++){
                if (j==0){
                    arr[j]  = matrix[i][j] +  Math.min(temparr[j], temparr[j+1]);
                } else if (j == (matrix[0].length - 1)){
                    arr[j]  = matrix[i][j] + Math.min(temparr[j], temparr[j-1]);
                } else{
                    temp = Math.min(temparr[j-1], temparr[j]);
                    temp = Math.min(temp, temparr[j+1]);
                    arr[j] = matrix[i][j] + temp;
                }
            }
            // System.out.println(Arrays.toString(arr));
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.stream(arr).min().getAsInt());
        return Arrays.stream(arr).min().getAsInt();
    }
}