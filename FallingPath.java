public class FallingPath {
    
    public static void main(String[] args)
    {
        int[][] input =  {{17,2,27},{26,5,16},{14,3,19},{1,7,2}};
        System.out.println("Min falling path : " + fallingPath(input));

    }

    //Time complexity: O(n^2)
    //Space Complexity: O(1) reusing existing array
    //passes on leetcode
    public static int fallingPath(int[][] arr)
    {
        int min_element = Integer.MAX_VALUE;
         
        for(int i=arr.length-2 ; i >= 0; i--)
        {   
            
            for(int j = 0; j< arr[i].length; j++)
            {
                
                if(j==0)
                {
                    arr[i][j] = arr[i][j] + Math.min(arr[i+1][j],arr[i+1][j+1]);
                }
                else if(j== arr[i].length-1)
                {
                    arr[i][j] = arr[i][j] + Math.min(arr[i+1][j],arr[i+1][j-1]);
                }
                else
                {
                    arr[i][j] = arr[i][j] + Math.min(arr[i+1][j],Math.min(arr[i+1][j+1],arr[i+1][j-1]));
                }
                
            }

        }

        for(int i=0; i<arr[0].length;i++)
        {
            min_element = Math.min(min_element,arr[0][i]);
        }

        return min_element;
    }

}
