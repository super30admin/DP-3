// Time Complexity : O(mn)  m=number of rows n=number of columns
// Space Complexity :O(1)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class MinFallPath {
	public static int minFallingPathSum(int[][] arr) {
		int min = Integer.MAX_VALUE;
		if (arr[0].length == 1 && arr.length == 1) {
			return arr[0][0];
		}
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = 0; j < arr[0].length; j++) {
				if (j == 0) {
					arr[i][j] += Math.min(arr[i + 1][j], arr[i + 1][j + 1]);
				} else if (j == arr[0].length - 1) {
					arr[i][j] += Math.min(arr[i + 1][j], arr[i + 1][j - 1]);
				} else {
					arr[i][j] += Math.min(arr[i + 1][j], Math.min(arr[i + 1][j - 1], arr[i + 1][j + 1]));
				}
				if (i == 0) {
					min = Math.min(arr[i][j], min);
				}
			}
		}
		return min;
	}
}