/*
Time Complexity: O(n)
Space Complexity: O(n)

Approach: First map distinct values into keys and their total amount in value arrays.
Then for each index of value array, we have two options:
opt1: don't take current value, take the max gained from next index
opt2: take the current value and the max gained from the next index having key >= current key + 2
*/

class Solution {
public:
    vector<int> key, val;

    int solve(){
       int n = key.size();
      
       vector<int> dp(n,0);
       dp[n-1] = val[n-1];

       for(int i=n-2;i>=0;i--) {
         int opt1 = 0, opt2 = 0;
         
         //option1: don't take the current element and take max gain from next
         opt1 = dp[i+1];

         int next_take = key[i]+1 == key[i+1] ?  i+2 : i+1;
         if(next_take < n)  opt2 = val[i] + dp[next_take];  //option2: take the current element and take max gain from the first element > v[i]+1
         else  opt2 = val[i];

         dp[i] = max(opt1,opt2);
       }

       return dp[0];
    }

    int deleteAndEarn(vector<int>& v) {
      sort(v.begin(),v.end());
      
      key = val = {v[0]};
      for(int i=1;i<v.size();i++){
        if(v[i]==v[i-1])  val[val.size()-1] += v[i];
        else  val.push_back(v[i]), key.push_back(v[i]);
      }

      return solve();
    }
};
