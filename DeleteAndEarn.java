/**
 * TC: O(n) SC: O(k), k is the max element among the given array
 * Approach : Store the frequency of each element as the sum of that element in new array and iterate through the array 
 *            checking for the max sum, if including that elemnts's sum increases the maxSum or not, 
 *            if not move forward else change the sum at that index in the new Array.   
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;
        int max= 0;
        //find max element to make the new array of size max
        for(int x: nums){
            max = Math.max(max,x);
        }
        int[] sumArr = new int[max+1];
        //put sum at the given index in new array
        for(int i = 0; i < nums.length; i++){
            sumArr[nums[i]] += nums[i]; 
        }
        //check whether to include the element or not
        for(int i= 2; i < sumArr.length; i++){
            sumArr[i] = Math.max(sumArr[i-1],sumArr[i]+sumArr[i-2]);
        }
        return Math.max(sumArr[sumArr.length-2],sumArr[sumArr.length-1]);
    }
}