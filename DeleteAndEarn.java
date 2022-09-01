// Time Complexity- O(n) + O(max element in input Array)
// Space Complexity - O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        // null check
        if (nums==null || nums.length ==0) return 0;

        int max = nums[0];
        for(int num:nums){
            max = Math.max(max,num);
        }

        int[] arr = new int[max+1];
        for(int num:nums){
            arr[num] += num;
        }

        int prev =0;
        int curr = arr[1];
        for(int i=2; i<arr.length; i++){
            int temp = curr;
            curr = Math.max( curr, prev + arr[i] ) ;
            prev = temp;
        }

        return curr;
    }
}