// Time Complexity : O(n) + O(max(n))
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        //finding max value number
        for(int num: nums){
            max = Math.max(num, max);
        }
        //creating max value array
        int[] arr = new int[max+1];
        for(int num: nums){
            arr[num] +=num;
        }
        //house robber logic on the arr
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++){
            int temp = curr;
            curr = Math.max(prev + arr[i],temp);
            prev  = temp;
        }
        return curr;
    }
}