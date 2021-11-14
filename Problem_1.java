// Time Complexity : O(Max( n, maxNumber))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// find the max value among the range of numbers
// get the array with the lenght of max + 1 and store the sum of each number over there
// then do the house robber on the new array
// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if( nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        // find max
        for(int num : nums){
            max = Math.max(max, num);
        }
        // get the base array
        int [] arr = new int [max + 1];
        for(int num : nums){
            arr[num] += num;
        }
        // house robber
        int skip = 0;
        int take = arr[0];
        for(int i = 1; i < arr.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        return Math.max(skip , take);
    }
}