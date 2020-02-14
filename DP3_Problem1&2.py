-------------Problem 1---------------------------------
Time complexity: O(log N)
Space complexity: O(N) 
Executed in leetcode: No, logic only
Commments: I am slightly confused with this question
In the example, we delete 4 and earn 4. Thereafter, we delete 3 and add 2 to get 6. Shouldn't we add delete 3 and add 3?

My logic is similar to house robber problem in dp. Sort the array to find the highest number, let's call it Max_num. 
Create an array with zeros having as many numbers as the max_number+1. For all numbers in the  array, value can be set as the number 
itself in the newly built array.For the first 2 elements, we can set value as 0 and number at one itself. Thereafter, it can be the maximum of value at the point n,
value at n-1 and value at n-2. But am still figuring ouut the logic in white board. 

-------------Problem 2---------------------------------
Time complexity: m*O(log n) where m is amount and N is the no of elements 
Space complexity: O(n+m) where m is amount and N is the no of elements 
Executed in leetcode: Yes
Commments: We create a dp array with size equal to amount+, with the first element as 1. Thereafter, we create two for loops to iteratively update the 
variable with the updated amount by adding the difference between the updated amount and coin denomination. Finally, we return the last 
value as the result.

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """

        dp = [0]*(amount+1)
        dp[0] = 1
        for coin in coins:
            for updated_amount in range(coin, amount+1):
                dp[updated_amount] += dp[updated_amount-coin]
        return dp[-1]
        
