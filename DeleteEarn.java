// TC: O(N) since we are traversing each element in the array once.
// SC: O(N) where we are storing given input values in new array/

// We are storing the sum of similar values into that value index so that we obtain the sum of all the repeated numbers in one index. 
// Once we have the sum of similar numbers, we are checking if we choosing that number or nor. If we choose that number, we calculate the 
// maximum of sum of not choosen and present value and choosen. this will give us the present maximum, this way, we are omitting the previous or next
// element which says us to delete numbers, next number and previous number. If we choose alternatively, we do not have to delete values.

public class DeleteEarn {

	public int EarnedAmt(int[] nums) {
		
		int[] values = new int[10001];
		for(int n: nums) {
			values[n] += n;
		}
		
		int C = 0;
		int NC = 0;
		
		for(int value: values) {
			int temp = Math.max(NC+value, C);
			
			NC = C;
			C = temp;
		}
		return C;
	}
	public static void main(String[] args) {
		
		DeleteEarn de = new DeleteEarn();
		int[] nums = {2,2,3,3,3,4};
		System.out.println(de.EarnedAmt(nums));
	}
}
