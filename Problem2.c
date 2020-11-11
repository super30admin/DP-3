
/* Problem Statement: 
Verified on LeetCode

Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.

 

Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation: 
The possible falling paths are:

    [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
    [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
    [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]

The falling path with the smallest sum is [1,4,7], so the answer is 12.

 

Note:

    1 <= A.length == A[0].length <= 100
    -100 <= A[i][j] <= 100

 * Best Solution : DYNAMIC PROGRAMMING (save space by overwriting the original array)
 * Time Complexity : O(n*m) where n is number of rows, m is number of columns 
 * Space Complexity : O(1)
 */

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define INT_MAX 99999
#define MAX_ROWS 20000


/* Macro for calculating max value among 2 numbers */
#ifndef max
    #define max(a,b) ((a) > (b) ? (a) : (b))
#endif

/* Macro for calculating min value among 2 numbers */
#ifndef min
    #define min(a,b) ((a) > (b) ? (b) : (a))
#endif

/* This function takes 2D array and its rows and columns as input and performs the following
 * tasks
 *1. Validations for invalid input
 *2. Start traversing from the second last row in the matrix
  * 2.1 For each element in the row, scan for all the elements in the next row which satisfy the condition that :
     is mentioned in the question.
   * 2.2 So after each iteration of a row, you will get the minimum possible value for that specific row and column
   * 
  * 2.3 At the end, you need to traverse the first row completely and find the minimum value. 
  *
  * The final answer will be the minimum of all the painted color option in the last house.
  *
 */
int minFallingPathSum(int** A, int ASize, int* AColSize){
    
    int idx = 0;
    int idx1 = 0;
    int min_sum = INT_MAX;
    int min_id = INT_MAX;

    /* As explained in the function, iterate over rows starting from second last row to the beginning */
    for (idx = ASize - 2; idx >= 0; idx--) {
        
        for (idx1 = 0; idx1 < *AColSize; idx1++) {
            /* For first element in the row, we cannot move to the lower left */
            /* For the last element in the row, we cannot move to the lower right */
            if (idx1 == 0) {
                min_id = min(A[idx + 1][idx1], A[idx + 1][idx1 + 1]);
            } else if (idx1 == (*AColSize - 1)) {
                min_id = min(A[idx + 1][idx1], A[idx + 1][idx1 - 1]);
            } else {
                min_id = min(A[idx + 1][idx1 -1 ], A[idx + 1][idx1]);
                min_id = min(min_id, A[idx + 1][idx1 + 1]);
            }
            /* Updating the input array entry with min possible sum at that stage */
            A[idx][idx1] = min_id + A[idx][idx1];
        }
        
    }
    /* iterate to get the final answer */
    min_sum = INT_MAX;
    for (idx1 = 0; idx1 < *AColSize; idx1++) {
        min_sum = min(min_sum, A[0][idx1]);     
    }

    return min_sum;
}
 
/* Optimized version of the above function with some changes in if condition */
int minFallingPathSum_ver2(int** A, int ASize, int* AColSize){
    
    int idx = 0;
    int idx1 = 0;
    int min_id = INT_MAX;
    int min_sum = INT_MAX;
    
    for (idx = ASize - 2; idx >= 0; idx--) {
        
        for (idx1 = 0; idx1 < *AColSize; idx1++) {
            /* initialize Minimum in the lower row with the element just below it */
            min_id = A[idx + 1][idx1];
            /* compare min_id with lower left number only if its not first element of the row */
            if (idx1 > 0) {
                min_id = min(min_id, A[idx + 1][idx1 - 1]);
            } /* compare min_id with lower right only if its not the last element in the row */
            if (idx1 < (*AColSize - 1)) {
                min_id = min(min_id, A[idx + 1][idx1 + 1]);
            }
            /* finally update the min for that specific row column value */
            A[idx][idx1] = min_id + A[idx][idx1];
        }       
    }
    /* Iterate over the first row to find your final answer */
    for (idx = 0; idx < *AColSize; idx++) {
        min_sum = min(min_sum, A[0][idx]);
    }

    return min_sum;
}

int main(int argc, char *argv[]) {
    int *cost_arr[MAX_ROWS] = {NULL};
    int num_of_col = 3;
    int idx = 0;

    /* For testing input array is not taken from user input */
    for (idx = 0; idx < 3; idx++) { 
        cost_arr[idx] = (int *)malloc(3*sizeof(int));
        if (cost_arr[idx] == NULL) {
            printf("Memory allocation failed for idx : %d\n", idx);
            return -1;
        }
    }
    /* sample test */
    cost_arr[0][0] = 1;
    cost_arr[0][1] = 2;
    cost_arr[0][2] = 3;

    cost_arr[1][0] = 4;
    cost_arr[1][1] = 5;
    cost_arr[1][2] = 6;

    cost_arr[2][0] = 7;
    cost_arr[2][1] = 8;
    cost_arr[2][2] = 9;
    /* Execute the dynamic programming solution for best results */
    printf("Min falling sum path is : %d\n", minFallingPathSum(cost_arr, 3, &num_of_col));

    /* Free memory  */
    for (idx = 0; idx < 3; idx++) { 
        free(cost_arr[idx]);
    }    
    return 0;
}
