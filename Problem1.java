//Time Complexity: O(maxele,maxeleinarray)
//Space Complexity :O(maxele) maxele in array 
public class Problem1 {

	 public static int deleteAndEarn(int[] nums) {
	        if(nums==null || nums.length==0)
	            return 0;
	        int maxnum= getmax(nums);
	        int[] sortedarr = new int[maxnum+1];
	        
	        for(int i=0;i<nums.length;i++){
	            sortedarr[nums[i]]+=nums[i];
	        }
	        
	        int c=0;
	        int dc=0;
	        
	        for(int i=0;i<sortedarr.length;i++){
	            int temp=dc;
	            dc= Math.max(c,dc);
	            c=temp+sortedarr[i];
	        }
	        
	        return Math.max(c,dc);
	    }
	    
	    private static int getmax(int[] nums){
	        int max= Integer.MIN_VALUE;
	        
	        for(int i: nums){
	            if(max<i){
	                max=i;
	            }
	        }
	        
	        return max;
	    }
	    
	    public static void main(String[] args) {
	    	int nums[] = new int[] {3,4,2};
	    	int res= deleteAndEarn(nums);
	    	System.out.println(res);
	    	
	    }
}
