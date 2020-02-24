/**
 * 
 */

/**
 * @author aupadhye
 *
 */
//Space complexity is O(n) and time complexity is O(n)
public class Max_delete_earn {

	/**
	 * 
	 */
	public Max_delete_earn() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static int deleteAndEarn(int[] nums) {
	       int[] count=new int[10001];
	       int max=0;
	       for(int i:nums){
	            count[i]++;
	            if(i>max) max=i;
	       }
	       for(int i=2;i<=max;i++) 
			   count[i]= Math.max(count[i]*i+count[i-2], count[i-1]);// Keep the max value for the array and then compute 
	       //the product of the present entry and the previous entry,with the present entry. Similar to house robber.
	       return count[max];
	   }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {3,4,2};
		System.out.println(deleteAndEarn(arr));
		
	}

}
