package sol;

public class DeleteAndEarn {

	 public int deleteAndEarn(int[] nums) {
	     int max=Integer.MIN_VALUE;
	          int maximum=Integer.MIN_VALUE;
	        for( int i=0;i<nums.length;i++){
	            if(nums[i]>maximum){maximum=nums[i];}
	        }
	    //    System.out.println(maximum);
	      
	        int hash[]=new int[maximum+1];
	        
	        
	        for(int i=0; i<nums.length;i++){
	            
	            hash[nums[i]]=hash[nums[i]]+nums[i];
	        }
	        
	    int taken=0;
	    int not_taken=0;
	        
	      for(int i=0;i<hash.length;i++){
	          
	          int tem=taken;
	          taken= not_taken+hash[i];
	          not_taken= Math.max(tem,not_taken);
	          max=Math.max(taken,not_taken);
	      }  
	        
	        
	        
	        return max;
	    }
	
	
}
