using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace S30_Problems
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
        }
        // Time Complexity: O(m*n)
        // Space Complexity: O(1) Since manupulating the input, no extra space is used.

        public int MinFallingPathSum(int[][] matrix) {
          for(int i = 1; i < matrix.Length; i++){
              for(int j = 0; j<matrix[0].Length; j++){
                  int minVal = matrix[i-1][j];
                  if(j>0) minVal = Math.Min(minVal,matrix[i-1][j-1]);
                  if(j<matrix[0].Length-1) minVal = Math.Min(minVal,matrix[i-1][j+1]);
                  matrix[i][j] += minVal; 
              }
          }
          int res = matrix[matrix.Length-1][0];
          for(int i = 1; i<matrix[0].Length; i++)
              res = Math.Min(res, matrix[matrix.Length-1][i]);
          return res;
      }
      
      // Time Complexity: O(klogk + n + 3*k) where n is the total number of elements, and k is the number of unique elements
      // Space Complexity: O(2k) space for dictionary and dp array
      public int DeleteAndEarn(int[] nums) {
          Dictionary<int, int> dict = new Dictionary<int, int>();
          foreach(int num in nums){
              if(!dict.ContainsKey(num)) dict.Add(num,0);
              dict[num]+=num;;
          }
          int[] a = dict.Keys.ToArray();
          Array.Sort(a);
          int[] dp = new int[a.Length+1];
          dp[0] = 0;
          dp[1] = dict[a[0]];
          for(int i = 2; i<=a.Length; i++){
              if(a[i-2] == a[i-1]-1){
                  dp[i] = Math.Max(dict[a[i-1]] + dp[i-2] , dp[i-1]);
              }
              else{
                  dp[i] = dp[i-1] + dict[a[i - 1]];
              }
          }
          return dp[a.Length];
      }
    }
}
