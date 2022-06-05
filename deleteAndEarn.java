class Solution {
    //Time complexity: O(n)+O(max(n))
    //Space complexity: O(max(n))
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
        }
        int[] arr=new int[max+1];
        for(int i:nums){
            arr[i]+=i;
        }
        int prev=arr[0];
        int curr=Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
            int temp=curr;
            curr=Math.max(arr[i]+prev,temp);
            prev=temp;
        }
        return curr;
    }
}