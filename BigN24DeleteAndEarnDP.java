// Time Complexity is iteration of values array size which is max of nums so O(max(nums)) --> O(n)
// Space complexity is O(max(nums))
// this solution is accepted on leetcode

public class BigN24DeleteAndEarnDP {
	    public int deleteAndEarn(int[] nums) {
	        //edge case:
	        if(nums == null || nums.length ==0)
	            return 0;
	        int [] values = new int[10001];
	        for(int i =0;i<nums.length;i++){
	            int temp = nums[i];
	            values[temp] += temp;
	        }
	        int notChoosen = 0;
	        int choosen = 0;
	        for(int i =0;i<values.length;i++){
	            int tempp = notChoosen;
	            notChoosen = Math.max(notChoosen,choosen);
	            choosen = tempp + values[i];
	        }
	        return Math.max(notChoosen,choosen);
	    }
	}