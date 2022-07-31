// Time Complexity : O(n + max(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class SolDeleteEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)return 0;

        // find the max value of the nums array and make a new array with the length m+1 (to make house robber pattern)
        int max = 0;
        for(int num : nums){
            max = Math.max(max,num);
        }

        int[] arr = new int[max+1];
        // put each value of nums array to the new array as per it's corresponding index and put the summation is case of same value.
        for(int num : nums){
            arr[num] += num;
        }

        // now we can not choose the adjcent numbers in array to make programme work.
        // so used the two variable to get the maximun value by keeping track of the maxValue_till_prev_cell and maxValue_till_curr_cell.
        int prev = arr[0];
        if(arr.length == 1)return arr[0];
        int curr = Math.max(arr[0],arr[1]);

        for(int i=2; i<arr.length; i++){
            int tmp = curr;
            curr = Math.max(tmp, prev+arr[i]);
            prev = tmp;
        }

        return curr;
    }

}