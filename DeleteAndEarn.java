class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        int maxn = 0;
        for(int i: nums){
            maxn = Math.max(maxn,i);
        }
        int [] arr = new int [maxn+1];
        for(int num: nums){
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0],arr[1]);
        for(int i = 2; i<arr.length;i++){
            int temp = curr;
            curr = Math.max(temp, arr[i]+prev);
            prev = temp;
        }
        return curr;
    }
}