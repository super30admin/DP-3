public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max = nums[0];
        // get the max element in nums array
        for(int num:nums){ // O(n)
            max = Math.max(max,num);
        }
        
        int[] sums_array = new int[max+1];
        
        // build the sums array
        for(int num:nums){ // O(n)
            sums_array[num]+=num;
        }
        int prev = 0;
        int curr = sums_array[1];
        
        // dp solution
        for(int i=2;i<sums_array.length;i++){ // O(max element in nums array)
            int temp = curr;
            curr = Math.max(curr, sums_array[i]+prev);
            prev = temp;
        }
        return curr;
    }
}


// Time Complexity - O(n) + O(max)
// Space Complexity - (n)
