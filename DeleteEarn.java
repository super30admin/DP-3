class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max+1];

        for (int num: nums) {
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0],arr[1]);
        for (int i=2; i<arr.length; i++){
            int temp = curr;
            curr= Math.max(curr,prev+arr[i]);
            prev = temp;
        }
        return curr;
    }
}