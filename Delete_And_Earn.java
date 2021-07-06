/*
    Time Complexity : O(N)
    Space Complexity : O(N) Auxilary Array space
    is Worked on leetcode : YES
    logic: create a new array for calculating the total earning if each house at perticular index 
    is selected, then the new subproblem is similar to houseRobber problem
*/

public class Delete_And_Earn {
    public int deleteAndEarn(int[] nums) {
        
        if(nums == null  || nums.length == 0){
            return 0;
        }
        
        int max=0;
        for(int i=0;i<nums.length ;i++){
            max = Math.max(max, nums[i]);
        }
        
        int arr[] = new int[max+1];
        for(int num :  nums){
            arr[num]= num + arr[num];
        }
        
        int skip = 0;
        int take = 0;
        for(int i=1;i<arr.length;i++){
            int temp = skip;
//             if you dont select a number that means you get what maximum availabel previous
            skip = Math.max(temp, take);
//             if you take it then you will get what previous availabel by not choosing the previous + current num
            
            take = temp + arr[i];
        }
        
        return Math.max(take,skip);
    }
}


