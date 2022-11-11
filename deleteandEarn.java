/*
Time Complexity -->
O(n)

Space Complexity-->
O(1)

Approach--.
Similar to house robber where we can choose between the adjacents and check for the the maximum. 
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {

      // compare all elements with max
      // assign maximum value to max
        max = Math.max(max, nums[i]);

        }
        System.out.println(max);
        int arr[] = new int[max+1];
        
        //  for(int j=0;j<arr.length;j++){
        //     System.out.println(arr[]);
        // }//for
        
        for(int i=0;i<nums.length;i++){// count number of frequency
            arr[nums[i]]+=1;
        }//for
                       
        // for(int j=0;j<arr.length;j++){
        //     System.out.println(arr[j]);
        // }//for
        
        int nottake = 0;
        int take = arr[0];
        int tmp = 0;
        for(int i=1;i<arr.length;i++){
            tmp = nottake;
            nottake = Math.max(nottake, take);
            take = tmp+arr[i]*i;
        }
        
        return Math.max(nottake, take);
    }
}
                       