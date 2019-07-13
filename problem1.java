public class problem1 {

    public static int findBestTimeStockTrade(int[] arr) {
        
        int low = arr[0], high = -1, lowArr = 0;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]<=low && i!=arr.length-1) {
                low = arr[i];
                lowArr = i;
            }
            if(arr[i]>=high) {
                if(i > lowArr && arr[i]>low) {
                    System.out.println(i+"lowArr"+lowArr);
                    high = arr[i];
                }
                else {
                    
                }
                
            }
        }
        if(high!=-1) return high-low;
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int result = findBestTimeStockTrade(arr);
        System.out.println(result);
    }
}