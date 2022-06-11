// Time Complexity: O(n) + O(max(n))
//Space Complexity: O(max(n))
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int num: nums){
            max = Math.max(num,max);
        }
        int arr[] = new int [max+1];
        //if(nums.length<2)return nums[0];
        for(int num : nums){
            arr[num] += num;
        }
        //house robber
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i = 2;i<arr.length;i++){
            int temp = curr;
            curr = Math.max(prev + arr[i], temp);
            prev = temp;
        }
        return curr;
    }
}