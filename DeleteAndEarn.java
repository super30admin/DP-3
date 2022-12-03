//Time Complexity :O(N)+O(K) where N is the size of given array and K is the max element in given array

//Space Complexity :O(K) 
//Did this code successfully run on Leetcode :Yes
//Any problem you faced while coding this : No 


public class DeleteAndEarn {
	
	  public int deleteAndEarn(int[] nums) {
		    // we will make an array of total sum of all numbers 
		    // thn we can use house robber concept on this problem 
		    // find max number so that we can make array for numbers and sum of those numbers 
		    
		    int max = 0;
		   //[2,2,3,3,3,4] - Max = 4
		    for(int i=0;i<nums.length;i++){
		        max = Math.max(max,nums[i]);
		    }
		    int[] arr = new int[max+1];

		         // arr = {0,0,4,9,4}
		        for(int i=0;i<nums.length;i++){
		            arr[nums[i]] = nums[i]+arr[nums[i]];
		        }
		        int rob =0;
		        int noRob =0;

		        for(int i=0;i<arr.length;i++){
		            int temp = noRob;
		            noRob = Math.max(rob,noRob);
		            rob = temp+arr[i];
		        }

		        return Math.max(rob,noRob);


		    }
		}

