class Solution {
    public int deleteAndEarn(int[] nums) {
        int max =0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int[] arr = new int[max+1];
        for(int num:nums){
            arr[num]+=num;
        }
        int prev = arr[0];
        int curr = Math.max(arr[0],arr[1]);
        for(int i=2;i<=max;i++){
            int temp = curr;
            curr=Math.max(curr,arr[i] +prev);
            prev=temp;

        }
        return curr;
    }
}