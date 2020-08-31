// Time Complexity : O(N) N - Max( max_elem, array_length)
// Space Complexity : O(M) M - max element in the array
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


//Store the sum of similar values into the value index. We obtain all repeated numbers in value index.
//We can choose the number or not choose. 
//If we choose the number, then values at value-1 and value+1 index are not considered for the max sum. 
//The problem reduces to house robber. 

public class DeleteAndEarn {

    public static int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] tracker  = new int[getMax(nums)+1];
        
        for(int i=0; i< nums.length; i++){
            tracker[nums[i]] += nums[i];
        }
        
        int C = 0, DC = 0;
        for(int i = 0; i<tracker.length; i++){
            int temp = DC;
            DC = Math.max(C,DC);
            C = tracker[i]+temp;
        }
        return Math.max(C,DC);
    }
    
    private static int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static void main(String[] args){
        int[] arr = {4,3,3,3,2,2};

        System.out.println(deleteAndEarn(arr));

    }

    
}