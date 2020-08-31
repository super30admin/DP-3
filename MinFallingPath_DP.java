package s30;


	public class MinFallingPath_DP {
		public static int minSum = Integer.MAX_VALUE;
		public static void main(String[] args) {
			int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
			System.out.println(getMinPath(arr));
		}
		public static int cols, rows;
		public static int MAXVAL = 101;
		
		public static int getMinPath(int[][] nums) {
			int rows = nums.length;
			int cols = 0;
			if(rows > 0) {
				cols = nums[0].length;
			}
			int[] prevArr = new int[cols];
			int[] currArr = new int[cols];
			
			for(int i=0; i<cols; i++) {
				prevArr[i] = nums[0][i];
			}
			
			for(int row=1; row<rows; row++) {
				for(int col = 0; col< cols; col++) {
					int currVal = nums[row][col] + Math.min(Math.min(getPreviousValue(prevArr, col-1), getPreviousValue(prevArr, col)), 
							 getPreviousValue(prevArr, col+1));
					currArr[col] = currVal;
				}
				
				int[] temp = prevArr;
				prevArr = currArr;
				currArr = temp;
				fillZeroes(currArr);
			}
			return getMinVal(prevArr);
			
		}
		
		public static int getPreviousValue(int[] prevArr, int col) {
			return (col >= 0 && col < prevArr.length) ? prevArr[col] : MAXVAL;
		}
		
		private static void fillZeroes(int[] arr) {
			for(int i=0; i<arr.length; i++) {
				arr[i] = 0;
			}
		}
		
		private static int getMinVal(int[] arr) {
			//get minval in last row
			int min = Integer.MAX_VALUE;
			for(int i=0; i<arr.length; i++) {
				min = arr[i] < min ? arr[i] : min;
			}
			return min;
		}
	}

