// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//In this approach we are first getting the max value from the input array and then creating a new array of size equal to the max value.
//We then create a 2-d matrix where we fill in the value trying to get the max value from the previous choose and dont choose.
//The new array we created , here for each index , we get the total to that index.
//If we choose an element , we add the not choose value from previous element
// and the total of this element from the new array we created. For the not choose of current , we get the max of the choose and don't choose from previous.
// The last row in this 2-d matrix has the max we can get from the input and we return that as the result to the original problem.
class Solution {
    public int deleteAndEarn(int[] nums) {
    //if input is null return 0
    if(nums == null || nums.length==0)
    {
        return 0;
    }

    //new array to store total of each digit from the input array
    int n = getMax(nums)+1;
    int newArr[] = new int [n];
        for(int i=0;i<nums.length;i++)
        {
            newArr[nums[i]] += nums[i]; 
        }

    int m = 2;
    //2-d array to maintain the max total we can get  
    int matrix[][] = new int[n][m];

    for(int i = 1;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            if (j==0)
            {
                matrix[i][j] = matrix[i-1][1] + newArr[i];
            }
            else
            {
                matrix[i][j] = Math.max(matrix[i-1][0],matrix[i-1][1]);
            }
        }
    }


        return Math.max(matrix[n-1][0],matrix[n-1][1]);
    }
    //function to get max value from an array
    public int getMax(int[] nums)
    {
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max = nums[i];
            }
        }
        return max;
    }
}