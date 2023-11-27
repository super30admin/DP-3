// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes https://leetcode.com/problems/delete-and-earn/
// Any problem you faced while coding this : -


/*
Sol: Get the max of the elements. Create an array with max+1 length and store the value of each delete in the array at the
index of element. Traverse through the sorted value array and get max value to return
 */
public class DeleteAndEarn{
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length ==1) return nums[0];
        //Identify the max number in the array
        int max = 0;
        for(int i=0;i<nums.length; i++) { //O(n)
            max = Math.max(nums[i],max);
        }

        //create a sorted array with freq values array of length max+1 O(n)
        int[] f = new int[max+1];

        for(int i=0;i<nums.length;i++){
            f[nums[i]] += nums[i];
        }

        int temp1 = f[0];
        int temp2 = Math.max(f[0],f[1]);
        int res = temp2;
        for(int i=2;i<=max;i++){
            res = Math.max(temp2, f[i]+temp1);
            temp1 = temp2;
            temp2 = res;
        }

        return res;
    }
}
