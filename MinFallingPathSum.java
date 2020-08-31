// Time Complexity : O(N*N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinFallingPathSum{
    public static void main(String[] args){
        MinFallingPathSum mfps = new MinFallingPathSum();
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int result=mfps.minFallingPathSum(nums);
        System.out.print("Result: " +result);
    }
    public int minFallingPathSum(int[][] A) {

        //Using the same approach of House Paint problem except for the second for loop as the number of columns is not fixed here.

        for(int i=1;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                //for the first column element, only the top and top-right elements are accessible
                if(j==0){
                    A[i][j]+= Math.min(A[i-1][j],A[i-1][j+1]);
                }
                //for the last column element, only the top and top-left elements are accessible
                else if(j==A[0].length-1){
                    A[i][j]+= Math.min(A[i-1][j],A[i-1][j-1]);
                }
                //for the rest of the middle elements, top-left, to,top-right elements are accessible.
                else {
                    A[i][j]+=Math.min(A[i-1][j-1],Math.min(A[i-1][j],A[i-1][j+1]));
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int num: A[A.length-1]){
            if(num<min)
                min=num;
        }
        //finding and returning the minimum number from the last row (As it is top-down approach: the bottom row will have the minimum paths)
        return min;
    }
}