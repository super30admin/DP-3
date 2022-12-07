// Time Complexity :O(n) n is the maximum number in array
// Space Complexity :O(n) n is the maximum number in array

/*
 * here we find the elements and store them in an array index according to 
 * their values. Now run the house robber algorithm on it.
 */

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++){
            maxNum = Math.max(maxNum, nums[i]);
        }
        int[] arr = new int[maxNum+1];
        
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]] += nums[i];
        }
        
        int prev = arr[0];
        int curr = arr[1];
        for(int i = 2; i < arr.length; i++){
            int temp = curr;
            curr = Math.max(arr[i]+prev, curr);
            prev = temp;
        }
        return curr;
    }    
}
