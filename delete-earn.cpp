class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n = nums.size();
       
       
        int maxi = 0;
        for(int num : nums){
            maxi = max(maxi,num);
        }

         int arr[maxi+1];

       for(int i=0;i<maxi+1;i++){
           arr[i] = 0;
       }
        for(int i=0;i< n;i++){
            int curr = nums[i];
            arr[curr] += curr;
               
        }

    
        int dp[maxi+1];
        dp[0] = arr[0];
        dp[1] = max(arr[0],arr[1]);

        for(int i=2 ; i<maxi+1 ; i++){
         
        }
    
        return dp[maxi];
    }
};


