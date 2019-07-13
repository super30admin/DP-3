//
// Created by shazmaan on 7/12/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{
public:
    int minFallingPathSum(vector<vector<int>>& A){
        int dp[A.size()][A[0].size()];
        for(int x =0; x<A[0].size(); x++){
            dp[0][x]=A[0][x];
        }
        int minVal;
        for(int i =1; i<A.size(); i++){
            for(int j = 0; j<A[0].size(); j++){
                minVal = INT_MAX;
                for(int x =j-1; x<j+2; x++){
                    if(x<A[0].size() && x>=0 && dp[i-1][x]<minVal){
                        minVal =  dp[i-1][x];
                    }
                }
                dp[i][j] = A[i][j]+minVal;
            }
        }
        return *min_element(dp[A.size()-1],dp[A.size()-1]+A[0].size());
    }
//    int minFallingPathSum(vector<vector<int>>& A) {
//        int minVal; int retSum = 0;
//        int start, end, index, nextMin, prevMin;
//        for(int i = 0; i<A.size(); i++){
//            minVal = INT_MAX; nextMin = INT_MAX;
//            if(i+1<A.size()){
//                nextMin = distance(A[i+1].begin(),min_element(A[i+1].begin(),A[i+1].end()));
//            }
//            if(i==0){
//                for(int j = 0; j<A[0].size(); j++){
//                    prevMin = minVal;
//                    if(A[i][j]<minVal){
//                        minVal=A[i][j];
//                        index = j;
//                    }
//                    if(index+1 != nextMin && index-1 != nextMin){
//                        minVal = prevMin;
//                    }
//                }
//            }else{
//                if(index-1>=0){start = index-1;}else{start = index;}
//                if(index+1<A[i].size()){end = index+1;}else{end = index;}
////                cout<<start<<" : "<<end<<endl;
//                for(int j = start; j<end+1; j++){
//                    prevMin = minVal;
//                    if(A[i][j]<minVal){minVal=A[i][j]; index = j;}
//                    if(index+1 != nextMin && index-1 != nextMin){
//                        minVal = prevMin;
//                    }
//                }
//            }
////            cout<<minVal<<" minVal "<<index<<" index\n";
//            retSum+=minVal;
//        }
//        return retSum;
//    }
};

int main(){
    Solution s;
    vector<vector<int>> vec{{1,2,3},{4,5,6},{7,8,9}};
    vector<vector<int>> vec2{{1,2,3,4},{4,-1,3,-2},{-2,5,-3,2},{7,-6,9,8}};
    vector<vector<int>> vec3{{-80,-13,22},{83,94,-5},{73,-48,61}};
    cout<<s.minFallingPathSum(vec3);
    return 0;
}