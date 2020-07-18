// Time Complexity : O(n^2). n is the length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
   public int minFallingPathSum(int[][] a) {
		if (a == null && a.length == 0)
			return -1;

		for (int i = 1; i < a[0].length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				
				int element = a[i-1][j];
				if(j-1>=0)
				element=Math.min(a[i-1][j-1],a[i-1][j]);
				
				if(j+1<a[0].length)
					element = Math.min(element, a[i-1][j+1]);
				
				a[i][j]=a[i][j]+element;
					
			}
		}
		int length = a[0].length-1;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<a[0].length;i++) {
			min = Math.min(min, a[length][i]);
		}
		return min;
	}
}
