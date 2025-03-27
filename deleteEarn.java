// HashMap approach to save space. TC remains same

import java.util.HashMap;

class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = 0;
        // int n = nums.length
        for(int num: nums){
            max = Math.max(max,num);
        }

        int[] arr = new int[max+1];
        for(int num: nums){
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i = 2; i<arr.length;i++){
            int temp = curr;
            curr = Math.max(curr, arr[i]+prev);
            prev = temp;
        }

        return curr;
        
    }
}//DP Array 1D - but without a dp array

// class Solution {
//     public int deleteAndEarn(int[] nums) {
//         int max = 0;
//         // int n = nums.length
//         for(int num: nums){
//             max = Math.max(max,num);
//         }

//         int[] arr = new int[max+1];
//         for(int num: nums){
//             arr[num] += num;
//         }

//         int prev = arr[0];
//         int curr = Math.max(arr[0], arr[1]);

//         for(int i = 2; i<arr.length;i++){
//             int temp = curr;
//             curr = Math.max(curr, arr[i]+prev);
//             prev = temp;
//         }

//         return curr;
        
//     }
// }