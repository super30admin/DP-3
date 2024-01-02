//740. Delete and Earn

/*
First get maximum value in the array, and get sum of all frequencies of an element

Time Complexity: O(N)
Space Complexity: O(N)

*/

class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {

        
        //using arrays
        int maxE = INT_MIN;
        //get max valued element
        for(int n:nums) maxE = max(maxE, n);
        vector<int> summ(maxE+1); //+1 cause index starts from 0

        //get sum of all freqs
        for(int n:nums) summ[n]+=n;

        int prev = summ[0];
        int curr = summ[1];

        for(int i=2; i<summ.size();i++){
            int temp = curr;
            curr = max(curr, summ[i]+prev);
            prev = temp;
        }

        return curr;
        

        //using hashed maps
        
    }
};