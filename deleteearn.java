// Time Complexity :O(max(n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach:find out the maximum in the array and then initialize an arry with max+1 space the traverse through the array and store the occurances sum in the adjacent iden then apply DP for repeation between max of previous and the current and the number added.
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int max=Integer.MIN_VALUE;
        for(int num: nums){
            max=Math.max(max,num);            
        }
        int [] arr= new int [max+1];
        for(int num:nums){
            arr[num]+=num;
        }
        int prev=arr[0];
        int curr=arr[1];
        for(int i=2;i<arr.length;i++){
            int temp = curr;
            curr=Math.max(curr,arr[i]+prev);
            prev=temp;
        }
        return curr;
    }
}