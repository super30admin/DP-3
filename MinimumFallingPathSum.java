// Time Complexity : O(m) where m = n*n for a 2D nXn matrix
// Space Complexity : O(m> where m = n*n or the total number of elements in a 2D nxn matrix
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

class MinimumFallingPathSum {

    private int[] arr;
    private int MAX = 99999;
    private int numOfColumns;
    private int numOfRows;

    public int minFallingPathSum(int[][] matrix)
    {
        if(matrix == null || matrix.length < 1)
        {
            return 0;
        }

        numOfRows = matrix.length;
        numOfColumns = matrix[0].length;

        arr = new int[ numOfRows * numOfColumns];
        for(int i = 0; i<arr.length; i++)
        {
            arr[i] = MAX;
        }
        return getPathSum(matrix, arr.length -1);
    }

    private int getPathSum(int[][] nums, int currentIndex)
    {
        for(int i=0; i<arr.length; i++)
        {
            int currentRow = i/numOfColumns;
            int currentColumn = i%numOfColumns;
            //if first row

            if(currentRow == 0)
            {
                arr[i] = nums[0][i];
            }
            else
            {
                //first column
                if(currentColumn == 0)
                {
                    arr[i] = nums[currentRow][currentColumn] +
                            Math.min(arr[getArrIndexfrom2D(currentRow-1, currentColumn)],
                                    arr[getArrIndexfrom2D(currentRow-1 , currentColumn +1)]);
                }
                else if(currentColumn == numOfColumns -1)
                {
                    arr[i] = nums[currentRow][currentColumn] +
                            Math.min(arr[getArrIndexfrom2D(currentRow-1, currentColumn)],
                                    arr[getArrIndexfrom2D(currentRow-1 ,currentColumn -1)]
                            );
                }
                else
                {
                    arr[i] = nums[currentRow][currentColumn] +
                            Math.min(arr[getArrIndexfrom2D(currentRow-1, currentColumn-1)],
                                    Math.min(arr[getArrIndexfrom2D(currentRow-1 ,currentColumn)],
                                            arr[getArrIndexfrom2D(currentRow-1, currentColumn+1)])
                            );
                }
            }
        }

        //minValue from the last row
        int minValue = MAX;
        for(int i = arr.length-1; i > arr.length-1 - numOfColumns;i--)
        {
            minValue = Math.min(minValue, arr[i]);
        }
        return minValue;
    }

    private int getArrIndexfrom2D(int rowNumber, int columnNuber)
    {
        return (rowNumber * numOfColumns) + columnNuber;
    }
    public static void main(String[] args) {
        MinimumFallingPathSum obj = new MinimumFallingPathSum();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        int[][] matrix2 = {{-19,57},{-40, -5}};
        System.out.println("Result: " + obj.minFallingPathSum(matrix));
        System.out.println("Result: " + obj.minFallingPathSum(matrix2));
    }
}