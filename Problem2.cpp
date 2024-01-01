//Time Complexity : O(N * M)
//Space Complexity :  O(1)

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {

        for(int row = matrix.size()-2; row >= 0; row--){ //iterating over every row starting from the second last row.
        
            for(int col = 0; col < matrix[0].size(); col++){ //now going through every column.
//depending on the col we have we will edit the current element
                if(col == 0){ //if col is starting then we have two choices bottom and bottom right
                matrix[row][col] += min(matrix[row+1][col], matrix[row+1][col+1]);
                }
                else if(col == matrix[0].size()-1){ //if col is last then we have two choices bottom and bottom left
                matrix[row][col] += min(matrix[row+1][col], matrix[row+1][col-1]);
                }
                else{ //if col is in middle then we have three choices bottom left, bottom and bottom right
                    int a = matrix[row+1][col];
                    int b = matrix[row+1][col-1];
                    int c = matrix[row+1][col+1];
                    int small = INT_MAX;

                    if(a < small) small = a;
                    if(b < small) small = b;
                    if(c < small) small = c;

                    matrix[row][col] += small;
                }
                //in all the above ifs we are adding the minimum of all elements available in row+1 to the current element
            }
        }
        return *min_element(matrix[0].begin(), matrix[0].end()); //returning the minimum of the accumulated sum that is present in first row (0th index)
    }
};