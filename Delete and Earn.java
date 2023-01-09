// Time Complexity = O(n) + O[max(n)]
// Space Complexity = O(k)  where k = O[max(n)]


class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null ||nums.length == 0) return 0;
        int max = nums[0];
        for (int num:nums){
            max = Math.max(max, num);
        }
        int [] arr = new int[max+1];
        for(int num:nums){
            arr[num] += num;
        }
        int prev = arr[0]; 
        int curr = Math.max(arr[0], arr[1]);
        for(int i =2; i<arr.length;i++){
            int temp = curr;
            curr = Math.max(curr, prev + arr[i]);
            prev = temp;
        }   
        return curr;
    }
}