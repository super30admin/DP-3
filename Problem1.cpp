// Time Complexity : O(n + max(arr)) n is elements in array and max(arr) is maximum value in array
// Space Complexity : O(max(arr))
// Did this code successfully run on Leetcode : Yes


// Your code here along with comments explaining your approach:
// 1. Use hash map to store frequency of elements. 
// 2. create array with size= max value in array and similarly solve like house robber.

class Solution {
public:
    int maxt(int a,int b,int c){
        if(a>b){
            if(a>c){
                return a;
            }else{return c;}
        }else{
            if(b>c){return b;}else{return c;}
        }
    }
    int deleteAndEarn(vector<int>& nums) {
        map<int,int> m;
        int n=nums.size(),x=-1;
        for(int i=0;i<n;i++){
            m[nums[i]]++;if(x<nums[i]){x=nums[i];}            
        }
        cout<<x<<'\n';
        int arr[x+1];arr[0]=0;
        arr[1]=m[1];
        for(int i=2;i<=x;i++){
            int s=(arr[i-2]+i*m[i]),f=(arr[i-1]),t=(arr[i-2]);
            arr[i]=maxt(s,f,t);
            cout<<arr[i]<<' ';
        }
        return arr[x];
    }
};