class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& A) {
        if(A.size()==0) return 0;
        for(int i=1; i<A.size(); i++){
            for(int j=0; j<A.size(); j++){
                if(j==0){
                    A.at(i).at(j) = A.at(i).at(j) + min(A.at(i-1).at(j),A.at(i-1).at(j+1));
                }
                else if(j==A.size()-1){
                    A.at(i).at(j) = A.at(i).at(j) + min(A.at(i-1).at(j), A.at(i-1).at(j-1));
                }
                else{
                    A.at(i).at(j) = A.at(i).at(j) + min(A.at(i-1).at(j), min(A.at(i-1).at(j-1),A.at(i-1).at(j+1))); 
                }
            }
        }
        int min = INT_MAX;
        for(int i=0; i<A.size(); i++){
            if(A.at(A.size()-1).at(i)<min){
                min = A.at(A.size()-1).at(i);
            }
        }
        return min;
    }
};