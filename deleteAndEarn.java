class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) return 0;

        int max = nums[0];
        for(int num:nums){
            max = Math.max(num,max);
        }

        int [] arr = new int[max+1];

        for(int num : nums){
            arr[num] +=num;
        }
        int prev = arr[0];
        int curr = arr[1];

        for(int i=2 ; i<arr.length; i++){
            int temp = curr;
            curr = Math.max(curr,arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}



/**

TC = O(N + M) ---> 'N' for Iterating through the nums array, and 'M' for Iterating through the array to find max number.

SC = O(M) ---> Due to the extra array.

Description : Creating new array and Storing the sum of each number to that perticular index. Then doing houseRober pattern to the new array gives us the maximum number of points.





 */