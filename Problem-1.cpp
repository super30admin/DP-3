740. Delete and Earn


TC Omax(n,k) n = number if integers in nums, k = max value
SC = O(k) 


class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {
        int n = nums.size();
        if (n==0) return 0;
        int maximum = nums[0];

        for(int num : nums) {
            maximum = max(num, maximum);
        }
        int arr[maximum+1];

        for(int i=0; i<=maximum; i++){
           arr[i] = 0;
        } 
        for(int num : nums){
            arr[num] += num;
        }       

        int prev = arr[0];
        int cur = max(arr[0], arr[1]);
        for(int i=2; i<=maximum; i++) {
            int temp = cur;
            cur = max(cur, (prev+arr[i]));
            prev = temp;
        }
        return cur;
    }
};
