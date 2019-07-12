import java.util.*;
// Time Complexity : o(n)
// Space Complexity :o(1)

class MaxProfit {
      public static int maxProfit(int[] arr) {
          int min_price = Integer.MAX_VALUE;
          int max_profit=0;
          for(int i=0;i<arr.length;i++){
              if(arr[i]<min_price){
                  min_price=arr[i];
              }else if(arr[i] - min_price > max_profit){
                  max_profit = arr[i] - min_price;
              }
          }
      
        return max_profit;
    }
  
	public static void main (String[] args) {
	  int arr[] = {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));
		
	}
}