//Time complexity of this function: O(n) n is length of prices
//Space Complexity of this function: O(1)

//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this: no
public class Max_Profit {
	
    public static int maxProfit(int[] prices) {
        int minValue=  Integer.MAX_VALUE;
        int maxProfit=0;
        
        //iterate over input array 
        for(int i=0; i<prices.length; i++){
        	//check is element is less than min value then update min value with element
            if(prices[i]<minValue){
               minValue= prices[i]; 
            }else{
            	// if element is greater than min value then take difference. and check if difference is greater than max profit then update maxprofit with difference
                if((prices[i] - minValue) > maxProfit){
                    maxProfit = prices[i] - minValue;
                }
            }
        }
        //return max profit
          return maxProfit;
        
    }
    
    public static void main(String[] args) {
    	int[] array= {7,1,5,3,6,4};
    	int result = maxProfit(array);
    	System.out.println( "maximum profit is="+result);
    	
    }

}
