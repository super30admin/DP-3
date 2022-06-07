/*
This approach uses a bottom up DP solution to solve the problem. We first create an
array that stores all the maximum sums for all the numbers in the array. A maximum sum of
a number is, the number multiplied by the frequency of the number in the array. We then use
this array of maximum number sums to progressively construct the final sum, by evaluating the 
maximum obtainable sum at any location starting from the first. This approach also optimises
the solution by using only one array to compute the solution

Did this run on leetcode: Yes

Problems with the code: None


*/
class Solution {
    //Time complexity: O(n)+O(max(n)) where n is number of elements and max(n) is the highest value element
    public int deleteAndEarn(int[] nums) {
        
        int max = 0;
        //Calculating the maximum element of thearray
        for(int n: nums)
            max = Math.max(n, max);
        //Maximum sum array
        int sumArray[] = new int[max+1];
        //Storing maximum number sums
        for(int n:nums)
            sumArray[n] += n;
        //Base values
        int prev = sumArray[0];
        int curr = Math.max(sumArray[0],sumArray[1]);
        
        for(int i = 2; i < sumArray.length; i++)
        {
            int temp = curr;
            curr = Math.max(temp, prev + sumArray[i]);
            prev = temp;
        }
        
        return curr;
    }
}