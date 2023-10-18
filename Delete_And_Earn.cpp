class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
      int n=nums.size();
      if(n==0)return 0;
      int max1 = INT_MIN;
      for(auto num:nums){
          max1 = max(max1, num);
      }
      int *arr = new int[max1+1];
      for(int i=0;i<(max1+1);i++)arr[i]=0;
      for(auto num:nums){
          arr[num]+=num;
      }
      int prev=arr[0];
      int current = max(arr[0], arr[1]);
      for(int i=2;i<(max1+1);i++){
          int temp = current;
          current = max(current, (prev + arr[i]));
          prev = temp;
      }
      return current;
    }
};
