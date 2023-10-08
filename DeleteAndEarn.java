//maximum number of points we can get, so max operations
//store it in the array with number as index and the sum that it forms
//for instance we have array of {1,1,4,5,6,3,1,2}
//we create an array with sum [0,3,2,3,4,5,6] (at 0 it is 0, at 1 it is(1+1+1) which make 3
//after which it becomes a house robber problem and we use the optimized solution

//Time Complexity: O(n)
//Space Complexity: O(n) -- biggest element in the array
//works on leetcode


public class DeleteAndEarn {

    public static void main(String[] args)
    {
        int nums[] = {2,2,3,3,3,4};
        System.out.println("The maximum points we can get is " + deleteAndEarn(nums));
    }
    
    public static int deleteAndEarn(int[] nums) {
        
        if(nums == null || nums.length == 0) return 0;        
    
        int max = Integer.MIN_VALUE;
    
        for(int i=0; i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
        }
    
        int []arr = new int[max + 1];
    
        for(int num: nums)
        {
            arr[num] += num;
        }
    
        int prev = arr[0];
        int curr = Math.max(arr[0],arr[1]);
    
        for(int i=2;i<arr.length;i++)
        {
            int temp = curr;
            curr = Math.max(arr[i] + prev, curr);
            prev = temp;
        }
    
        return curr;
        }

}
